package prac19.prac19.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prac19.prac19.Entities.Book;
import prac19.prac19.Repositories.BookRepository;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        List<Book> result = bookRepository.findAll();
        log.info(result.size() + " was founded!");
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        log.info("book added");
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        log.info("book with id " + id + "deleted");
        bookRepository.deleteBookById(id);
    }
    public List<Book> getBooksByName(String bookName) {
        List<Book> result = bookRepository.findGamesByNameLike(bookName);
        log.info("founded " + result.size() + "records");
        return result;
    }
    public Book getBookById(Long id) {
        return bookRepository.findGameById(id);
    }
}