package prac16.prac16.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prac16.prac16.Entities.Author;
import prac16.prac16.Entities.Book;
import prac16.prac16.Services.AuthorService;
import prac16.prac16.Services.BookService;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    @PostMapping(value="/books/{bookName}")
    public Book addBook(@PathVariable String bookName){
        Book newBook = new Book();
        newBook.setName(bookName);
        newBook.setCreationDate(new Date());
        newBook.setAuthor(authorService.getAuthors().get(0));
        bookService.addBook(newBook);
        return newBook;
    }
    @DeleteMapping("/books/{book_id}")
    public void deleteBook(@PathVariable long book_id) {
        bookService.deleteBook(book_id);
    }
}
