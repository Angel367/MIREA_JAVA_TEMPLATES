public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1_1 = Singleton1.getInstance();
        Singleton1 singleton1_2 = Singleton1.getInstance();

        Singleton2 singleton2_1 = Singleton2.getInstance();
        Singleton2 singleton2_2 = Singleton2.getInstance();
        Singleton2 singleton2_3 = Singleton2.INSTANCE;

        Singleton3 singleton3_1 = Singleton3.getInstance();
        Singleton3 singleton3_2 = Singleton3.getInstance();

        System.out.println("Первый вариант:");
        System.out.println(singleton1_1.hashCode() + " " + singleton1_2.hashCode());

        System.out.println("Второй вариант:");
        System.out.println(singleton2_1.hashCode() + " " + singleton2_2.hashCode() + " "
                + singleton2_3.hashCode());

        System.out.println("Третий вариант:");
        System.out.println(singleton3_1.hashCode() + " " + singleton3_2.hashCode());

    }
}
