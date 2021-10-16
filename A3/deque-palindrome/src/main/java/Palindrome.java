public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i=0; i<word.length(); i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        if (word.length() <= 1) {return true;}
        Deque<Character> words = wordToDeque(word);
        for(int i=0; i<word.length()/2; i++){
            if(words.removeFirst() != words.removeLast()) { return false; }
        }
        return true;
    }

    // this function is compare palindrome by Offbyone  "acefdb" is palindrome
    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() <= 1) {return true;}
        for(int i=0; i<word.length()/2; i++){
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length()-i-1))) {
                return false;
            }
        }
        return true;
    }
}


