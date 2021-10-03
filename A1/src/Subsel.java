import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a, int stride){
        return takeEvery(a, stride, 0);
    }

    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        int[] args = new int[0];
        if (stride < 0) {
            for (int i=beginWith; i!=-1; i+=stride){
                args =addToArray(args, a[i]);
            }
        } else {
            for (int i=beginWith; i<a.length; i+=stride) {
                args =addToArray(args, a[i]);
            }
        }
        return args;
    }

    public static int[] addToArray(int[] args, int n) {
        // create new array that have 1 more space
        int[] newArgs = new int[args.length + 1];

        // copy old array to new one
        for (int i=0; i<args.length; i++) {
            newArgs[i] = args[i];
        }

        // append number into array
        newArgs[newArgs.length - 1] = n;
        return newArgs;
    }
    public static void main(String[] args) {
//        int[] a ={1,2,3};
//        a = addToArray(a,5);
//        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(takeEvery(new int[]{1, 2, 3, 4},2)));
        System.out.println(Arrays.toString(takeEvery(new int[]{2, 7, 1, 8, 4, 5},3,2)));
        System.out.println(Arrays.toString(takeEvery(new int[]{3, 1, 4, 5, 9, 2, 6, 5},-1,5)));
    }
}
