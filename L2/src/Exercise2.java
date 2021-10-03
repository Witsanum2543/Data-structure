import java.math.BigInteger;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(numTrailingZeros(30));

        int[] a = {1, 2, -3, 4, 5, 4};
        int[] b = {1, -1, -1, 10, 5 ,-1};
        windowPosSum(b, 2);
        System.out.println(Arrays.toString(b));
    }
    public static int numTrailingZeros(int n) {
        BigInteger nFac = BigInteger.valueOf(1);

        for (int i=1; i<=n; i++){
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }
        int nZero = 0;
        while (nFac.remainder(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
            nFac = nFac.divide(BigInteger.valueOf(10));
            nZero++;
        }
        return nZero;
    }

    public static void windowPosSum(int[] a, int n){
        for (int i=0; i<a.length ; i++){
            if (a[i] >= 0) {
                    for (int j=1 ; j<=n & j<=(a.length - 1 - i) ; j++) {
                        a[i] += a[i + j];
                    }
                }
            }
        }
}
