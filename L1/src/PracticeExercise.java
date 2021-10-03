public class PracticeExercise {
    public static void main(String[] args) {

        byte secondsInAMinute = 60;
        int secondsInAnHour = 60 * secondsInAMinute;
        int secondsInADay = 24 * secondsInAnHour;
        int secondsInAYear = 365 * secondsInADay;
        long secondsInACentury = 100 * secondsInAYear;

        System.out.printf("One century contains %d seconds.\n", secondsInAYear );
    }
}
