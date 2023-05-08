package prac17.prac17.Services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import prac17.prac17.Entities.Book;

import java.util.List;

@Component
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    public BookService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    @PreDestroy
    public void destroySession() {
        session.close();
    }
    public List<Book> getBooks() {
        return session.createQuery("select b FROM Book b", Book.class).getResultList();
    }

    public void addBook(Book book) {
        session.beginTransaction();
        session.saveOrUpdate(book);
        session.getTransaction().commit();
    }
    public void deleteBook(Long id) {
        session.beginTransaction();
        Book bookById = session.get(Book.class, id);
        session.delete(bookById);
        session.getTransaction().commit();
    }
    public List<Book> getBooksByName(String bookName) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(builder.like(root.get("name"), "%"+bookName+"%"));
        return session.createQuery(query).getResultList();
    }
    public Book getBookById(Long id) {
        return session.get(Book.class, id);
    }
}