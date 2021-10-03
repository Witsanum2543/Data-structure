import java.math.BigInteger;

public class Fib {

    public static int firstNDigit(int n) {
        int count = 1;

        while (digitCount(fibonacci(count)) != n) {
            count += 1;
        }

        return count;

    }


    public static int digitCount(BigInteger n) {
        int digit = 0;
        while (!n.equals(BigInteger.valueOf(0))) {
            digit += 1;
            n = n.divide(BigInteger.valueOf(10));
        }
        return digit;
    }

    public static BigInteger fibonacci(int n) {

        if (n==1||n==2) {
            return BigInteger.valueOf(1);
        }

        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger ans = BigInteger.valueOf(0);

        for (int i=2; i<n; i++) {

            // ans = a + b
            ans = a.add(b);
            a = b;
            b = ans;
        }

        return ans;
    }
    public static void main(String[] args) {

        System.out.println(firstNDigit(1));
        System.out.println(firstNDigit(2));
        System.out.println(firstNDigit(4));
        System.out.println(fibonacci(17));
    }
}
