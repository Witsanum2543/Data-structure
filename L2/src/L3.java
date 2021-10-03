public class L3 {
    public static void arrayPrintDemo() {
        int[] numbers = new int[]{3, 1, 4, 2, 8};
        // for
        for (int numItem: numbers) {
            System.out.println("--- " + numItem);
        }
        // while
        int index = 0;
        while (index < numbers.length) {
            System.out.println("--- " + numbers[index]);
            index++;
        }
        // C-Style for
        for (int dex = 0; dex < numbers.length; dex++) {
            System.out.println("---" + numbers[dex]);
        }
    }

    public static int maxFullFor(int[] numbers) {
        int MaxSoFar = numbers[0];

        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] > MaxSoFar)
                MaxSoFar = numbers[i];
        }
        return MaxSoFar;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 4, 5};
        System.out.println(numbers);

    }
}
