package prac16.prac16.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prac16.prac16.Entities.Author;
import prac16.prac16.Services.AuthorService;

import java.util.Date;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
    @PostMapping(value="/authors/{authorName}")
    public Author addAuthor(@PathVariable String authorName){
        Author newAuthor = new Author();
        newAuthor.setFirstName(authorName);
        newAuthor.setBirthDate(new Date());
        authorService.addAuthor(newAuthor);
        return newAuthor;
    }
    @DeleteMapping("/authors/{author_id}")
    public void deleteAuthor(@PathVariable long author_id) {
        authorService.deleteAuthor(author_id);
    }

}
