package Application;

import Components.Kostya;
import Configs.BeanConfig;
import Interfaces.Programmer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Prac10Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        try {
            for (String s: context.getBeanDefinitionNames())
                System.out.println(s);
            Kostya kostya =  new Kostya(context.getBean(args[0], Programmer.class));
            kostya.code();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("Expected 1 command line argument");
        }
    }
}
