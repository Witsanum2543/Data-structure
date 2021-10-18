public class PrefixSum {
    static int sumInt(int x, int y){
        return x + y;
    }

    // Return the prefix sum array of numbers
    // prefix({3, 1, 4, 2}) == {3, 4, 8, 10}
    static int[] prefixSum(int[] numbers){
        int[] ans = new int[numbers.length];
        for (int i=0; i<numbers.length; i++){
            for (int j=0; j<=i; j++){
                ans[i] += numbers[j];
            }
        }
        return ans;
    }
}
