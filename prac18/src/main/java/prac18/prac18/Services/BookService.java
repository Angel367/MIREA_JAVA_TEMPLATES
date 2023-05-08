package prac18.prac18.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prac18.prac18.Entities.Book;
import prac18.prac18.Repositories.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteBookById(id);
    }
    public List<Book> getBooksByName(String bookName) {
        return bookRepository.findGamesByNameLike(bookName);
    }
    public Book getBookById(Long id) {
        return bookRepository.findGameById(id);
    }
}