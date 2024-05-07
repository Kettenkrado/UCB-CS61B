package deque;

public class LinkedListDeque<T> {
    private Node<T> sentinel;
    private int size;

    /** Create an empty deque. */
    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Create a deque with the first element */
    public LinkedListDeque(T item) {
        sentinel = new Node<>(item, null, null);
        sentinel.next = new Node<>(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        Node<T> first = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    public void addLast(T item) {
        Node<T> last = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

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

    public T getRecursive(Node<T> node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursive(node.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursive(sentinel.next, index);
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
