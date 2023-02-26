// Имплементировать интерфейс Function, получающий на вход массив строк и возвращающий массив отзеркаленных строк.
import java.util.function.Function;
public class Main {
    private static final int arrSize = 10;
    public static void main(String[] args) {
        String[] originalStrings = new String[arrSize];

        for (int i = 0; i < arrSize; i++)
            originalStrings[i] = Integer.toString(i);


        Function<String[], String[]> convert = baseStrings -> {
            String[] newStrings = new String[arrSize];
            for (int i = 0; i < baseStrings.length; i++)
                newStrings[baseStrings.length-i-1] = baseStrings[i];

            return newStrings;
        };

        String[] convertedStrings = convert.apply(originalStrings);

        for (int i = 0; i < arrSize; i++)
            System.out.print(convertedStrings[i] + " ");

    }
}
