package prac22.prac22.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import prac22.prac22.Entities.Book;
import prac22.prac22.Repositories.BookRepository;
import prac22.prac22.Services.BookService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @Test
    public void getUsers() {
        Book book = new Book(1L, "WE");
        BookService bookService = new BookService(bookRepository);
        bookRepository.save(book);
        Mockito.when(bookRepository.findAll()).thenReturn(List.of(book));
        Assertions.assertEquals(1L, bookService.getBooks().get(0).getId());
        Assertions.assertEquals("WE", bookService.getBooks().get(0).getName());
    }
}
