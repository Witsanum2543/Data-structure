import java.util.ArrayList;
import java.util.List;

public class L9 {
    long factHelper(int n, long a){
        if (n == 0) return a;
        else return factHelper(n-1,a*n);
    }
    long fact(int n) {return factHelper(n,1);}
    double betterpow(double b, int w) {
        if (w == 0) {return 1;}
        else{
            double t = betterpow(b, w/2)
            if (w%2 == 0){
                return t*t;
            } else {
                return t * t * b;
            }
        }
    }

    double pow(double b, int w){
        // base case
        if (w == 0) {return 1;}
        else {
            // Recursive
            return pow(b, w-1) * b;
        }
    }
    // change(25) = [5,5,5,5,5]
    List<Integer> change(int n){
        //base case(s)
        switch (n) {
            case 24: return List.of(5,5,7,7);
            case 25: return List.of(5,5,5,5,5);
            case 26: return List.of(7,7,7,5);
            case 27: return List.of(5,5,5,5,7);
            case 28: return List.of(7,7,7,7);
            default:
                List<Integer> sol = new ArrayList<>(change(n-5));
                sol.add(5);
                return sol;
        }
    }
    public static void main(String[] args) {

    }
}
