package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void equality() {
        StudentArrayDeque<Integer> L = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> L2 = new ArrayDequeSolution<>();
        int N = 5000;
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int randVal = StdRandom.uniform(N);
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                L.addLast(randVal);
                L2.addLast(randVal);
                msg.append("addLast(").append(randVal).append(")\n");
            } else if (operationNumber == 1) {
                L.addFirst(randVal);
                L2.addFirst(randVal);
                msg.append("addFirst(").append(randVal).append(")\n");
            } else if (operationNumber == 2) {
                if (L2.isEmpty()) {
                    continue;
                }
                assertEquals(msg.append("removeLast()\n").toString(), L2.removeLast(), L.removeLast());
            } else {
                if (L2.isEmpty()) {
                    continue;
                }
                assertEquals(msg.append("removeFirst()\n").toString(), L2.removeFirst(), L.removeFirst());
            }
        }
    }
}
