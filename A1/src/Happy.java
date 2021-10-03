import java.util.Arrays;

public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long ans = 0L;

        while (n != 0) {
            ans += (long) Math.pow(n % 10,2);
            n /= 10;
        }
        return ans;
    }

    public static boolean isHappy(long n) {

        while (n != 1 && n != 4) {
            n = sumOfDigitsSquared(n);
        }

        if (n == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static long[] firstK(int k) {
        long[] ans = new long[k];
        long num = 1L;
        int index = 0;

        while (index != k){
            if (isHappy(num)) {
                ans[index] = num;
                num++;
                index++;
            } else {
                num++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        System.out.println(Arrays.toString(firstK(11)));

    }
}
