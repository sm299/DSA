package Recursion;

import java.util.ArrayList;
import java.util.List;

/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"] */

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = new ArrayList<>();
        genParan("", 0, 0, n, list);
        System.out.println(list);
    }

    public static void genParan(String str, int open, int close, int n, List<String> list) {
        if (str.length() == (2 * n)) {
            list.add(str);
            return;
        }
        if (open < n) {
            genParan(str + "(", open + 1, close, n, list);
        }
        if (open > close) {
            genParan(str + ")", open, close + 1, n, list);
        }

    }
}
