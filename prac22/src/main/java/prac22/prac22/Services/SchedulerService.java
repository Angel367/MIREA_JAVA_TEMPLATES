package prac22.prac22.Services;

import prac22.prac22.Entities.Book;
import prac22.prac22.Entities.Author;
import prac22.prac22.Repositories.AuthorRepository;
import prac22.prac22.Repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@ManagedResource //jconsole
public class SchedulerService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }

    @ManagedOperation(description = "backup")
    @Scheduled(cron = "*/30 * * * *")
    public void doScheduledTask() throws IOException {
        for (File myFile : new File("src/main/resources/data").listFiles()) {
            if (myFile.isFile()) myFile.delete();
        }
        List<Book> books = bookRepository.findAll();
        File bookFile = new File("src/main/resources/data/Games.txt");
        FileWriter writer = new FileWriter(bookFile, true);
        writer.write(books.toString());
        writer.close();
        List<Author> gameAuthors = authorRepository.findAll();
        File authorFile = new File("src/main/resources/data/GameAuthors.txt");
        writer = new FileWriter(authorFile, true);
        writer.write(gameAuthors.toString());
        writer.close();
        log.info("Backup");
    }
}