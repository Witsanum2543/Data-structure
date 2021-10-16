public class OffByN implements CharacterComparator {

    public int n;

    public OffByN(int N){
        this.n = N;
    }

    public boolean equalChars(char x, char y){
        if (x - y == -this.n || x - y == this.n){
            return true;
        } else {
            return false;
        }
    }
}