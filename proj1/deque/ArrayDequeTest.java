package deque;

import com.sun.source.tree.AssertTree;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayDequeTest {
    @Test
    public void visualize_add() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 100;
        for (int i = 0; i < N; i++) {
            int randVal = StdRandom.uniform(N);
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                L.addLast(randVal);
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
            }
        }
    }

    @Test
    public void visualize_remove() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 18;
        for (int i = 0; i < 12; i++) {
            L.addLast(i);
            L.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            L.removeFirst();
        }
        for (int i = 0; i < 12; i++) {
            L.addLast(i);
            L.addFirst(i);
        }
    }

    @Test
    public void iterable() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        ArrayDeque<Integer> L2 = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            L.addLast(4 - i);
        }
        for (int i : L) {
            L2.addFirst(i);
        }
        assertTrue("Size should be the same",L.size() == L2.size());
        assertEquals(L.get(0), L2.get(3));
        assertEquals(L.get(1), L2.get(2));
    }

    @Test
    public void equality() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        ArrayDeque<Integer> L2 = new ArrayDeque<>();
        int N = 100;
        for (int i = 0; i < N; i++) {
            int randVal = StdRandom.uniform(N);
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                L.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
                L2.addFirst(randVal);
            }
        }
        boolean equality = L.equals(L2);
        assertTrue("This two deques should be the same", equality);
    }

    @Test
    public void stringEquality() {
        // reference cmp may fail in my first version of test
        ArrayDeque<String> L = new ArrayDeque<>();
        ArrayDeque<String> L2 = new ArrayDeque<>();
        String x = "monkey";
        String y = "whatever";
        String z = "monkey";

        L.addFirst(x);
        L2.addFirst(z);
        L.addLast(y);
        L2.addLast("whatever");

        boolean equality = L.equals(L2);
        assertTrue("This two deques should be the same", equality);
    }
}
