package prac14.prac14.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prac14.prac14.Entities.Author;

import java.util.ArrayList;

@RestController
public class AuthorController {
    private ArrayList<Author> authors = new ArrayList<>();

    @GetMapping("/author")
    public ArrayList<Author> getAuthors(){
        return authors;
    }
    @PostMapping("/author")
    public Author addBook(Author newAuthor){
        authors.add(newAuthor);
        return newAuthor;
    }
    @DeleteMapping("/author")
    public Author deleteBook(Author delAuthor) {
        authors.remove(delAuthor);
        return delAuthor;
    }

}