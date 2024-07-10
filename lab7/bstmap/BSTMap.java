package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private class BSTNode{
        private K key;
        private V value;
        private BSTNode left, right;
        private int N;

        /* Constructor */
        public BSTNode(K key, V value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    private BSTNode root;

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(K key) {
        return (get(key) != null) || (getTest(key) != null);
    }

    @Override
    public V get(K key) {
        BSTNode current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return current.value;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    //fix the problem for test
    private BSTNode getTest(K key) {
        BSTNode current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                // if this key exists, and it's value is null, containsKey is true
                return current;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode x){
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode x, K key, V value) {
        if (x == null) {
            return new BSTNode(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        } x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        throw new UnsupportedOperationException();
    }
}