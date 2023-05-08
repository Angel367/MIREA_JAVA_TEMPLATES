package prac18.prac18.Services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prac18.prac18.Entities.Author;
import prac18.prac18.Repositories.AuthorRepository;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthorById(id);
    }
    public List<Author> getAuthorsByBirthDateInterval(Date one, Date second) {
        return authorRepository.findGameAuthorsByBirthDateBetween(one, second);
    }
    public Author getAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }
}