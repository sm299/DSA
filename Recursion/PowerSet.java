package Recursion;

import java.util.ArrayList;
import java.util.List;

//tc-> O(2^n*n) sc->O(1)

public class PowerSet {
    public static void main(String[] args) {
        String str = "abc";
        generatePowerSet(str);
    }

    public static void generatePowerSet(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < (1 << str.length()); i++) {
            String subStr = "";
            for (int j = 0; j < str.length(); j++) {
                if ((i & (1 << j)) != 0) {
                    subStr += str.charAt(j);
                }
            }
            list.add(subStr);
        }
        System.out.println(list);
    }
}
