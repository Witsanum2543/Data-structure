public class Diamond {
    public static void printDiamond(int k) {

        // top part until center
        for (int i=0; i<k ; i++) {

            // find how many star and hastag are in that line
            int star = 1 + (i * 2);
            int hastag = 2*k+1 - star;
            // plug in function
            printHashtagStar(hastag, star);

        }

        // bottom part
        for (int i=k-2; i>=0 ; i--) {

            int star = 1 + (i * 2);
            int hastag = 2*k+1 - star;
            printHashtagStar(hastag, star);
        }

    }

    public static void printHashtagStar(int hashtag, int star) {
        String line = "";
        for (int i=0; i<hashtag/2; i++){
            line += "#";
        }
        for (int i=0; i<star; i++){
            line += "*";
        }
        for (int i=0; i<hashtag/2; i++){
            line += "#";
        }
        System.out.println(line);
    }
    public static void main(String[] args) {
        printDiamond(4);
        printDiamond(3);

    }
}
