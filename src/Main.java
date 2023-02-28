import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(2);
        myExecutorService.execute(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Потом это");
        });

        myExecutorService.execute(() -> System.out.println("Сначала это"));
        myExecutorService.shutdown();
    }
}
