package String;

public class Atoi {
    public static void main(String[] args) {
        String s1 = "  -0042gh8990";
        System.out.println(atoi(s1));

    }

    public static int atoi(String s) {
        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            i++;

            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (result * sign);
    }
}
