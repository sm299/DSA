package Patern;

/* 
 *     A
 *    ABA
 *   ABCBA
 *  ABCDCBA
 * ABCDEDCBA
 */
public class AlphabetPattern1 {
    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }

    public static void pattern(int n) {
        // char a = 'A';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                char a = (char) ('A' + j);
                System.out.print(a);
            }
            for (int j = i - 1; j >= 0; j--) {
                char a = (char) ('A' + j);
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
