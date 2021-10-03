public class Hidden {

    public static boolean isHidden(String s, String t) {
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            if (count == t.length()) {
                return true;
            } else if (s.charAt(i) == t.charAt(count)) {
                count++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHidden("welcometothehotelcalifornia","melon"));
        System.out.println(isHidden("welcometothehotelcalifornia","space"));
        System.out.println(isHidden("TQ89MnQU3IC7t6","MUIC"));
        System.out.println(isHidden("VhHTdipc07","htc"));
        System.out.println(isHidden("VhHTdipc07","hTc"));

    }
}
