package Patern;

public class MathProblems {
    public static void main(String[] args) {
        int n = 505;
        numOfDigits(n);
        palindrom(n);
    }

    public static void numOfDigits(int n) {
        if (n == 0) {
            System.out.println(1);
        } else {
            System.out.println((int) Math.log10(Math.abs(n)) + 1);
        }
    }

    public static void palindrom(int n) {
        String s = String.valueOf(n);
        String[] arr = s.split("");
        boolean result = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - i - 1])) {
                result = false;
            }
        }
        if (result)
            System.out.println("Palindrom");
        else
            System.out.println("Not palindrom");
    }
}
