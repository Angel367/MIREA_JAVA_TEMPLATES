// Сортировка по весу в обратном порядке, фильтрация по фамилии не Иванов,
// сортировка по возрасту, произведение всех возрастов.

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Исходный список
        Stream<Human> stream = getHumanArrayList().stream();
        System.out.println("Исходный список");
        stream.forEach(System.out::println);
        stream = getHumanArrayList().stream();

        // Сортировка по весу в обратном порядке
        System.out.println("Сортировка по весу в обратном порядке");
        stream.sorted(Comparator.comparingInt(Human::getWeight).reversed()).forEach(System.out::println);
        stream = getHumanArrayList().stream();

        // Фильтрация по фамилии не Иванов
        System.out.println("Фильтрация по фамилии не Иванов");
        stream.filter(human -> !Objects.equals(human.lastName, "Иванов")).forEach(System.out::println);
        stream = getHumanArrayList().stream();

        // Сортировка по возрасту
        System.out.println("Сортировка по возрасту");
        stream.sorted(Comparator.comparingInt(Human::getAge)).forEach(System.out::println);
        stream = getHumanArrayList().stream();

        // Произведение всех возрастов
        int ans = stream.mapToInt(Human::getAge).reduce(1, ((left, right) -> left * right));
        System.out.println("Произведение всех возрастов: " + ans);

    }
    public static ArrayList<Human> getHumanArrayList() {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human(37, "Иван", "Алексеев", LocalDate.of(1985,
                9, 3), 72));
        humans.add(new Human(11, "Константин", "Иванов", LocalDate.of(2012,
                1, 5), 50));
        humans.add(new Human(29, "Николай", "Лабрадоров", LocalDate.of(2003,
                3, 12), 85));
        humans.add(new Human(40, "Евгения", "Петрова", LocalDate.of(1983,
                5, 12), 60));
        humans.add(new Human(12, "Макар", "Поперечный", LocalDate.of(2011,
                1, 7), 45));


        return humans;

    }
}
