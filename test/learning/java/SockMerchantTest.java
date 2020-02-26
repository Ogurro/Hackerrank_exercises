package learning.java;

import org.junit.Test;
import static org.junit.Assert.*;

public class SockMerchantTest {

    @Test
    public void countSocksPairs() {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int expectedVal = 3;
        assertEquals(expectedVal, SockMerchant.countSocksPairs(n, ar));
    }
}
