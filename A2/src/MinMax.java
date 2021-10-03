public class MinMax {
    public static void main(String[] args) {
        System.out.println(minMaxAverage(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
    }

    public static double minMaxAverage(int[] numbers) {
        int myMin = numbers[numbers.length -1];
        int myMax = numbers[numbers.length -1];
        int dynamicRange = numbers.length - (numbers.length%2); // difference between odd and even
        for (int i=0; i<dynamicRange; i+=2) {

            if (numbers[i] >= numbers[i+1]) {
                if (numbers[i] > myMax) {myMax = numbers[i];}
                if (numbers[i+1] < myMin) {myMin = numbers[i+1];}
            } else { // numbers[i] < numbers[i+1]
                if (numbers[i] < myMin) {myMin = numbers[i];}
                if (numbers[i+1] > myMax) {myMax = numbers[i+1];}
            }
        }
        return (myMax + myMin)/2.0;
    }


}
