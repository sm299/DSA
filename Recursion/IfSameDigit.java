package Recursion;

public class IfSameDigit {

    public static void main(String[] args) {
        // System.out.println("Try programiz.pro");
        String s = "3902";
        String f = "34789";
        isSame(s);
        isSame(f);
    }

    public static void isSame(String s) {
        // Long l=Long.valueOf(s);
        int[] arr = s.chars().map(c -> c - '0').toArray();
        // Long temp;
        String temp = "";
        for (int i = 0; i < s.length() - 1; i++) {
            temp = temp + ((arr[i] + arr[i + 1]) % 10);
        }
        if (temp.length() == 2) {
            System.out.println(temp.charAt(0) == temp.charAt(1));
        } else {
            isSame(temp);
        }
    }

}
