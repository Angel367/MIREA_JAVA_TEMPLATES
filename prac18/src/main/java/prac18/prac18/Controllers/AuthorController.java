package prac18.prac18.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prac18.prac18.Entities.Author;
import prac18.prac18.Services.AuthorService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @GetMapping("/authors/getByDateInterval/{firstDate}/{secondDate}")
    public List<Author> getAuthorsByBirthDateInterval(@PathVariable String firstDate, @PathVariable String secondDate) {
        try {
            Date d1 = new SimpleDateFormat("dd.MM.yyyy").parse(firstDate);
            Date d2 = new SimpleDateFormat("dd.MM.yyyy").parse(secondDate);
            return authorService.getAuthorsByBirthDateInterval(d1,d2);
        } catch (ParseException e) {
            System.out.println("Incorrect date");
            return null;
        }
    }
    @PostMapping(value = "/authors/fullInsertion/{firstName}/{lastName}/{middleName}/{date}")
    public Author addAuthorFullInsertionView (
            @PathVariable String firstName,
            @PathVariable String lastName,
            @PathVariable String middleName,
            @PathVariable String date
    ) {
        Date newDate;
        try {
            newDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        }
        catch (ParseException e) {
            System.out.println("Incorrect date");
            return null;
        }
        Author newAuthor = new Author();
        newAuthor.setFirstName(firstName);
        newAuthor.setLastName(lastName);
        newAuthor.setMiddleName(middleName);
        newAuthor.setBirthDate(newDate);
        authorService.addAuthor(newAuthor);
        return newAuthor;
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
