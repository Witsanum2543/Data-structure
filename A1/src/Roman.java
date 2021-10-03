public class Roman {
    public static int romanToInt(String romanNum) {
// 1954 : MCMLIV

// 1000 + 900 + 50 + 4
// M > C + 1000 ,  C < M -100  , M > L +1000 ,  L > I +50  , I < V -1 , V +5
// 1000 - 100 + 1000 + 50 - 1 + 5
        int ans = 0;
        for (int i=0; i<romanNum.length()-1; i++){

            if (valueConverter(romanNum.charAt(i)) >= valueConverter(romanNum.charAt(i+1))) {
                ans += valueConverter(romanNum.charAt(i));
            } else {
                ans -= valueConverter(romanNum.charAt(i));
            }
        }
        ans += valueConverter(romanNum.charAt(romanNum.length()-1));

        return ans;
    }
 

    public static int valueConverter(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMLIV"));
        System.out.println(romanToInt("MCMXC"));
        System.out.println(romanToInt("IX"));
    }
}

