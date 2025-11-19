package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombo {
    public static void main(String[] args) {
        String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> list = new ArrayList<>();
        String digits = "23";
        generate(digits.toCharArray(), arr, list, "", 0);
        System.out.println(list);
    }

    public static void generate(char[] arr, String[] strArr, List<String> list, String s, int ind) {
        if (ind == arr.length) {
            list.add(s);
            return;
        }
        // String[] temp = strArr[ind].split("");
        int num = arr[ind] - '0';
        for (int i = 0; i < strArr[num].length(); i++) {
            generate(arr, strArr, list, s + strArr[num].charAt(i), ind + 1);
        }
    }
}
