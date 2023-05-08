package prac21.prac21.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prac21.prac21.Entities.Author;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAll();
    Author save(Author entity);
    void deleteAuthorById(Long id);
    List<Author> findGameAuthorsByBirthDateBetween(Date one, Date two);
    Author findAuthorById(Long id);

}