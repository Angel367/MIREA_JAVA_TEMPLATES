import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMap<K, V> implements Map<K, V>{
    private final Map<Object, Object> map = new HashMap<Object, Object>();
    private final Lock lock = new ReentrantLock();


    @Override
    public int size() {
        lock.lock();
        try {
            return map.size();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return map.isEmpty();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        try {
            return map.containsKey(key);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        try {
            return map.containsKey(value);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        lock.lock();
        try {
            return (V) map.get(key);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        try {
            return (V) map.put(key, value);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        try {
            return (V) map.remove(key);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
