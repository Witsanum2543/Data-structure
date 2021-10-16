import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class OffByNTest {
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testOffbyOne() {
        assertEquals(true, offBy5.equalChars('a','f'));
        assertEquals(true, offBy5.equalChars('b','g'));
        assertEquals(true, offBy5.equalChars('c','h'));
        assertEquals(false, offBy5.equalChars('a','b'));
        assertEquals(false, offBy5.equalChars('a','c'));
        assertEquals(false, offBy5.equalChars('a','d'));
    }
}