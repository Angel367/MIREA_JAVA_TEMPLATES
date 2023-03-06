package FactoryMethodPattern;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();
        developers.add(Developer.of("JAVA"));
        developers.add(Developer.of("RUBY"));
        developers.forEach(developer->developer.write());
    }
}