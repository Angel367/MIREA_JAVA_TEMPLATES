package prac19.prac19.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prac19.prac19.Entities.Author;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAll();
    Author save(Author entity);
    void deleteAuthorById(Long id);
    List<Author> findGameAuthorsByBirthDateBetween(Date one, Date two);
    Author findAuthorById(Long id);

}