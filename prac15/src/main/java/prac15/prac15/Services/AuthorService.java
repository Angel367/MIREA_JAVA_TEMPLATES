package prac15.prac15.Services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import prac15.prac15.Entities.Author;

import java.util.List;

@Component
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    public AuthorService(SessionFactory sessionFactory) {
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
    public List<Author> getAuthors() {
        return session.createQuery("select a FROM Author a", Author.class).getResultList();
    }

    public void addAuthor(Author author) {
        session.beginTransaction();
        session.saveOrUpdate(author);
        session.getTransaction().commit();
    }
    public void deleteAuthor(Long id) {
        session.beginTransaction();
        Author authorById = session.get(Author.class, id);
        session.delete(authorById);
        session.getTransaction().commit();
    }
}