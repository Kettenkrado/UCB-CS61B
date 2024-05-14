package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int nextFirst, nextLast, size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = items.length - 1;
        nextLast = 0;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        size += 1;
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        size += 1;
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(nextFirst + 1 + i) % items.length];
        }
        nextFirst = newItems.length - 1;
        nextLast = size;
        items = newItems;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return items[(nextFirst + index + 1) % items.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length / size > 4 && items.length > 16) {
            resize(items.length / 4);
        }
        size -= 1;
        T item = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length / size > 4 && items.length > 16) {
            resize(items.length / 4);
        }
        size -= 1;
        T item = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        return item;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        ArrayDequeIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (o == this) {
            return true;
        }

        Deque<T> other = (Deque<T>) o;
        if (size != other.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (get(i) != other.get(i)) {
                return false;
            }
        }

        return true;
    }
}
