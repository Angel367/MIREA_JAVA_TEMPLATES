package prac21.prac21.Services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prac21.prac21.Entities.Author;
import prac21.prac21.Repositories.AuthorRepository;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        List<Author> result = authorRepository.findAll();
        log.info(result.size() + " was founded!");
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
        log.info("entity " + author.toString() + "saved successfully");
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