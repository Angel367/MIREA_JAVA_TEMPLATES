package prac22.prac22.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import prac22.prac22.Entities.Author;
import prac22.prac22.Repositories.AuthorRepository;
import prac22.prac22.Services.AuthorService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    @Test
    public void getUsers() {
        Author author = new Author(1L, "egor", "volkov", "alexandrovich");
        AuthorService authorService = new AuthorService(authorRepository);
        authorRepository.save(author);
        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author));
        Assertions.assertEquals("egor", authorService.getAuthors().get(0).getFirstName());
        Assertions.assertEquals("volkov", authorService.getAuthors().get(0).getLastName());
    }
}
