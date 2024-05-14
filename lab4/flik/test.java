package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    @Test
    public void whatHappensAt128() {
        int i = 128, j = 128;
        assertTrue("int 128 should be the same", j == i);
        Integer m = 128, n = 128;
        assertFalse("Integer 128 shouldn't be the same", m == n);

        Integer x = 127, y = 127;
        assertTrue("Integer 127 and 127 should be the same", x == y);
        /* Integer 类的 ValueOf 方法中有一个缓存机制，
        会先对数值进行判断，如果数值在默认的[-128:127]之间，则返回缓存的对象，否则就返回一个新的 Integer 对象。
        上限127 可以通过JVM提供的配置(-XX:AutoBoxCacheMax)进行修改。*/
    }
}
