package String;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("If Anagram in BF: " + anagramBF(s, t));
        System.out.println("If Anagram in OA: " + anagramOA(s, t));
        s = "rat";
        t = "car";
        System.out.println("If Anagram in BF: " + anagramBF(s, t));
        System.out.println("If Anagram in OA: " + anagramOA(s, t));
    }

    public static boolean anagramBF(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.equalsIgnoreCase(t))
            return true;
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (sMap.equals(tMap)) {
            return true;
        }
        return false;
    }

    public static boolean anagramOA(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26]; // fixed size for lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
