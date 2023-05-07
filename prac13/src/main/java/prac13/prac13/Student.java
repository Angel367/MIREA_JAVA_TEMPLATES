package prac13.prac13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${Student.name}")
    private String name;
    @Value("${Student.last_name}")
    private String last_name;
    @Value("${Student.group}")
    private String group;
    @PostConstruct
    public void init() { System.out.println(toString()); }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
