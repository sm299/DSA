package String;

public class LargestOddNumber {
    public static void main(String[] args) {
        String s1 = "002031468";
        String s2 = "2024";
        lon(s1);// TC->O(n2); SC->O(n)
        lon(s2);

        lonStr(s1);
    }

    public static void lon(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            int temp = Integer.parseInt(s.substring(0, i));
            if (temp % 2 != 0 && temp > result) {
                result = temp;
            }
        }
        if (result > 0)
            System.out.println("Largest Odd : " + result);
        else
            System.out.println("No Odd Number Can Be Constructed");
    }

    public static void lonStr(String s) {
        int i = 0;
        int n = s.length();

        int j;
        for (j = n - 1; j >= 0; j--) {
            if ((s.charAt(j) - '0') % 2 != 0) {

                break;
            }
        }
        if (j == -1) {
            System.out.println("No Odd Number Can Be Constructed");
            return;
        } else {
            while (i < n) {
                if (s.charAt(i) != '0') {
                    break;
                }
                i++;
            }
            System.out.println("OA : ");
            for (int k = i; k <= j; k++) {
                System.out.print(s.charAt(k));
            }
        }
    }
}
