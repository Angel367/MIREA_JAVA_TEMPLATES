package prac14.prac14.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prac14.prac14.Entities.Book;

import java.util.ArrayList;

@RestController
public class BookController {
    private ArrayList<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return books;
    }
    @PostMapping("/books")
    public Book addBook(Book newBook){
        books.add(newBook);
        return newBook;
    }
    @DeleteMapping("/books")
    public Book deleteBook(Book delBook) {
        books.remove(delBook);
        return delBook;
    }

}
