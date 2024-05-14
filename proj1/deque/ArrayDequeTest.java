package deque;

import org.junit.Test;
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
            L.printDeque();
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
}
