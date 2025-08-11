package String;

import java.util.ArrayList;
import java.util.List;

public class ReverseEveryWord {
    public static void main(String[] args) {
        String s = " Welcome to the  jungle";
        reverse(s);// TC->O(n) + O(n) + O(n) + O(n) → O(n); SC->O(n)
        System.out.println();
        reverseOA(s);
    }

    public static void reverse(String s) {
        String[] arr = s.trim().split("\\s+");
        int n = arr.length;
        for (int i = 0; i <= n / 2; i++) {
            String temp = arr[n - 1 - i];
            arr[n - 1 - i] = arr[i];
            arr[i] = temp;
        }

        for (String x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void reverseOA(String s) {
        int n = s.length();
        String result = "";
        List<String> words = new ArrayList<>();
        int start, end;
        int i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == ' ')
                i++;
            if (i >= n)
                break;
            start = i;
            while (i < n && s.charAt(i) != ' ')
                i++;

            end = i;
            String word = s.substring(start, end);
            words.add(word);

        }
        for (int j = words.size() - 1; j >= 0; j--) {
            result = result.concat(words.get(j));
            if (j != 0)
                result = result.concat(" ");
        }

        System.out.println("OA : " + result);
    }
}
