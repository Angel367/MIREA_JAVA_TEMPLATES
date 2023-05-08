package prac20.prac20.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prac20.prac20.Entities.Book;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findGameById(Long gameId);
    List<Book> findGamesByNameLike(String like);
    List<Book> findGamesByCreationDateBetween(Date one, Date two);
    void deleteBookById(Long bookId);
    Book save(Book entity);
    List<Book> findAll();
    void deleteAll();
}