package deque;

import java.util.NoSuchElementException;

public class ArrayDeque<T> {
    T[] items;
    int nextFirst, nextLast, size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = items.length - 1;
        nextLast = 0;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        size += 1;
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % items.length;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        size += 1;
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
    }

    public void resize(int capacity) {
        T[] new_items = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            new_items[i] = items[(nextFirst + 1 + i) % items.length];
        }
        nextFirst = new_items.length - 1;
        nextLast = size;
        items = new_items;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
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

    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (items.length / size > 4 && items.length > 16) {
            resize(items.length / 4);
        }
        size -= 1;
        T item = items[(nextLast - 1) % items.length];
        items[(nextLast - 1) % items.length] = null;
        nextLast = (nextLast - 1) % items.length;
        return item;
    }
}
