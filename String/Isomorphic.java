package String;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(s + " " + t + " if isomorphic : " + iso(s, t));
        s = "foo";
        t = "bar";
        System.out.println(s + " " + t + " if isomorphic : " + iso(s, t));

        System.out.println(s + " " + t + " if isomorphic : " + isIsomorphic(s, t));
    }

    public static boolean iso(String s, String t) { // failing when s=bacd and t=baba
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {

                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }

        return true;
    }
}
