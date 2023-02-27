import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LockMap<String, Integer> lockMap = new LockMap<>();
        lockMap.put("3", 12);
        lockMap.put("2", 12);
        lockMap.put("1", 12);
        System.out.println(lockMap.size());

        SynchronizedSet<Integer> synchronizedSet = new SynchronizedSet<>();
        synchronizedSet.add(3);
        System.out.println(synchronizedSet.isEmpty());

    }
}
