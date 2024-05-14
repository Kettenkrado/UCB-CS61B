package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private Node<T> sentinel;
    private int size;

    /** Create an empty deque. */
    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> first = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> last = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        T current = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return current;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        T current = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return current;
    }

    @Override
    public T get(int index) {
        Node<T> current = sentinel.next;
        int cnt = 0;
        while (current != sentinel) {
            if (cnt == index) {
                return current.item;
            }
            cnt += 1;
            current = current.next;
        }
        return null;
    }

    private T getRecursive(Node<T> node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursive(node.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size || index < 0) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<T> implements Iterator<T> {
        private int wizPos;
        public LinkedListIterator() { wizPos = 0; }
        public boolean hasNext() { return wizPos < size; }
        public T next() {
            T returnItem = (T) get(wizPos);
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

    private static class Node<T> {
        public T item;
        public Node<T> prev;
        public Node<T> next;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
