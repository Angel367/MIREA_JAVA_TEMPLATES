package prac15.prac15.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prac15.prac15.Entities.Book;
import prac15.prac15.Services.BookService;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    @PostMapping(value="/books/{bookName}")
    public Book addBook(@PathVariable String bookName){
        Book newBook = new Book();
        newBook.setName(bookName);
        newBook.setCreationDate(new Date());
        bookService.addBook(newBook);
        return newBook;
    }
    @DeleteMapping("/books/{book_id}")
    public void deleteBook(@PathVariable long book_id) {
        bookService.deleteBook(book_id);
    }
}
