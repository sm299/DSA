package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "III";
        System.out.println("Int value : " + rmi(s));
        System.out.println("Int value : " + rmi("IV"));
    }

    public static int rmi(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get(s.charAt(i + 1)) > romanMap.get(s.charAt(i))) {
                result = result - romanMap.get(s.charAt(i));
            } else {
                result = result + romanMap.get(s.charAt(i));
            }
        }
        return result;
    }
}
