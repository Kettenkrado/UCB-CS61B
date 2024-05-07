package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        for (int i = 0; i < 3; i++) {
            correct.addLast(i);
            buggy.addLast(i);
        }
        for (int i = 0; i < 3; i++) {
            int element1 = correct.removeLast();
            int element2 = buggy.removeLast();
            assertEquals(element1, element2);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                assertEquals(sizeL, sizeB);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0 && B.size() == 0) {
                    continue;
                }
                int last1 = L.getLast();
                int last2 = B.getLast();
                assertEquals(last1, last2);
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() == 0 || B.size() == 0) {
                    continue;
                }
                int last1 = L.removeLast();
                int last2 = B.removeLast();
                assertEquals(last1, last2);
            }
        }
    }
}
