// IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertEquals(false,palindrome.isPalindrome("Hello"));
        assertEquals(true,palindrome.isPalindrome("noon"));
        assertEquals(true,palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindrome2(){
        CharacterComparator cc = new OffByOne();
        assertEquals(false, palindrome.isPalindrome("Hello",cc));
        assertEquals(true, palindrome.isPalindrome("aceddb",cc));
        assertEquals(true, palindrome.isPalindrome("a",cc));
        assertEquals(true, palindrome.isPalindrome("hjki",cc));
    }
}

