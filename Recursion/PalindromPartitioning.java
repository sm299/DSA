package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PalindromPartitioning {
    public static void main(String[] args) {
        String s = "aabbc";
        List<List<String>> list = new ArrayList<>();
        generate(new ArrayList<String>(), list, s, 0);
        System.out.println(list);
    }

    public static void generate(ArrayList<String> list, List<List<String>> finalList, String c, int ind) {
        if (ind == c.length()) {
            finalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < c.length(); i++) {
            if (isPalindrom(c.substring(ind, i + 1))) {
                list.add(c.substring(ind, i + 1));
                generate(list, finalList, c, i + 1);
                list.remove(list.size() - 1);
                // generate(list, finalList, c.substring(ind, i), ind + 1);
            }
        }
    }

    public static boolean isPalindrom(String str) {
        if (str.length() == 1) {
            return true;
        }
        return IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }
}
