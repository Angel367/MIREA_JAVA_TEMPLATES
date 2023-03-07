package IteratorPattern;

import java.util.Iterator;

public class MyCollection implements Iterable<String> {
    private String[] items;
    private int size;

    public MyCollection(int capacity) {
        items = new String[capacity];
        size = 0;
    }

    public void add(String item) {
        if (size == items.length) {
            throw new RuntimeException("Collection is full");
        }
        items[size++] = item;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new RuntimeException("No more items in collection");
            }
            return items[index++];
        }
    }
}
