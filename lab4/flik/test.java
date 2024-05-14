package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    @Test
    public void whatHappensAt128() {
        int i = 128, j = 128;
        assertTrue("int 128 should be the same", j == i);
        Integer m = 128, n = 128;
        assertFalse("Integer 128 should be the same", m == n);
    }
}
