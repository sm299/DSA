package String;

public class RotateString {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "cdeab";
        System.out.println("Is rotated : " + rotate(s1, s2));// for more than one shift, this is failing

        System.out.println("Is rotated BF: " + rotateBF(s1, s2));// TC-> O(n2), SC->O(n)+O(n)
        System.out.println("Is rotated OA: " + rotateOA(s1, s2));
    }

    public static boolean rotate(String s1, String s2) {
        boolean isrotated = false;
        int count = 0;
        // int index = 0;
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s2.indexOf(s1.charAt(i), i) > i) {
                count++;
            }
        }
        if (count <= 1) {
            isrotated = true;
        }
        return isrotated;
    }

    public static boolean rotateBF(String s, String goal) {
        // boolean check = false;
        String left = "";
        String right = "";
        if (s.equals(goal))
            return true;
        for (int i = 0; i < s.length() - 1; i++) {
            right = s.substring(i);

            if (right.concat(left).equals(goal)) {
                return true;
            }
            left = left + s.charAt(i);
        }
        return false;
    }

    public static boolean rotateOA(String s, String goal) {
        if (s.equals(goal))
            return true;
        if (s.length() != goal.length())
            return false;
        s = s + s;
        return s.contains(goal);
    }
}
