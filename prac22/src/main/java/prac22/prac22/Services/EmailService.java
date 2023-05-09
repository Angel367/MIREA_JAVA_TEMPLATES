package prac22.prac22.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import prac22.prac22.Entities.Author;
import prac22.prac22.Entities.Book;

@Service
@Async
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;
    public void sendMessageBook(Book book) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("american.egor.volkov20038@gmail.com");
        message.setTo("egor.volkov2003@mail.ru");
        message.setSubject("Book");
        message.setText(book.toString());
        emailSender.send(message);
        log.info("Send email about {}", book);
    }
    public void sendMessageAuthor(Author author) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("american.egor.volkov20038@gmail.com");
        message.setTo("egor.volkov2003@mail.ru");
        message.setSubject("Author");
        message.setText(author.toString());
        emailSender.send(message);
        log.info("Send email about {}", author);
    }
}