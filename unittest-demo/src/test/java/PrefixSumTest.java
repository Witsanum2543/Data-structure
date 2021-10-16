import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixSumTest {

    @Test
    void sumInt() {
        assertEquals(15,PrefixSum.sumInt(7,8));
        assertEquals(9999,PrefixSum.sumInt(9998,1));
        assertEquals(0,PrefixSum.sumInt(-1,1));
    }

    @Test
    void prefixSum() {
        assertArrayEquals(new int[]{3, 4, 8, 10}, PrefixSum.prefixSum(new int[]{3, 1, 4, 2}));
        assertArrayEquals(new int[]{1, 3, 6, 10}, PrefixSum.prefixSum(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3 ,4 ,5}, PrefixSum.prefixSum(new int[]{1, 1, 1, 1, 1}));
    }
}