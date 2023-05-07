package prac12.prac12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;

@Component
public class FileHandler {
    @Autowired
    private ApplicationArguments applicationArguments;
    private boolean doesFirstFileExists = true;

    @PostConstruct
    public void file_hash() throws IOException {
        System.out.println("BEAN START");
        String file1_path = applicationArguments.getSourceArgs()[0];
        String file2_path = applicationArguments.getSourceArgs()[1];
        FileWriter writer = new FileWriter(file2_path);
        try (FileReader reader = new FileReader(file1_path)) {
            int c;
            StringBuilder file_data = new StringBuilder();
            while((c=reader.read()) != -1){
                file_data.append((char)c);
            }
            System.out.println("Origin data: " + file_data);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(file_data.toString().getBytes());
            String hashed_data = bytesToHex(hash);
            System.out.println("Hashed data: " + hashed_data);
            writer.write(hashed_data);
        }
        catch (Exception e) {
            System.out.println("FILE DOES NOT EXIST");
            doesFirstFileExists = false;
        }
        writer.flush();
        writer.close();
    }
    @PreDestroy
    public void file_delete() throws IOException {
        String file1_path = applicationArguments.getSourceArgs()[0];
        String file2_path = applicationArguments.getSourceArgs()[1];

        if (doesFirstFileExists) {
            File first = new File(file1_path);
            first.delete();
        }
        else {
            FileWriter writer = new FileWriter(file2_path);
            writer.write("null");
            writer.flush();
            writer.close();
        }

        System.out.println("BEAN DESTROY");
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
