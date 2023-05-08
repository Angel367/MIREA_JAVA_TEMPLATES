package prac16.prac16.Services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import prac16.prac16.Entities.Book;

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
}