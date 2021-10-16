// IMPORTANT:
// Uncomment this file after you have implemented OffByOne

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffbyOne() {
        assertEquals(true, offByOne.equalChars('a','b'));
        assertEquals(true, offByOne.equalChars('c','d'));
        assertEquals(true, offByOne.equalChars('e','f'));
        assertEquals(false, offByOne.equalChars('a','z'));
        assertEquals(false, offByOne.equalChars('a','c'));
        assertEquals(false, offByOne.equalChars('a','d'));
    }
}

