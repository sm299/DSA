package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Generate Binary Strings Without Consecutive 1s
Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.

A binary string is a string consisting only of characters '0' and '1'.

Examples:
Input: n = 3

Output: ["000", "001", "010", "100", "101"]

Explanation: All strings are of length 3 and do not contain consecutive 1s. */

public class BinaryStrings {
    public static void main(String args[]) {
        int n = 3;
        List<String> list = new ArrayList<>();
        generate(n, "", false, list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void generate(int n, String str, boolean prevOne, List<String> list) {
        if (str.length() == n) {
            list.add(str);
            return;
        }
        generate(n, str + "0", false, list);
        if (prevOne == false) {
            generate(n, str + "1", true, list);
        }
    }
}
