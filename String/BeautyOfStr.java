package String;

import java.util.HashMap;
import java.util.Map;

public class BeautyOfStr {
    public static void main(String args[]) {
        String s = "abaacc";
        bosBF(s);
        bosOA(s);
    }

    public static void bosBF(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int min = s.length();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (max < map.get(s.charAt(j))) {
                    max = map.get(s.charAt(j));
                }
                if (min > map.get(s.charAt(j))) {
                    min = map.get(s.charAt(j));
                }
                res += (max - min);
            }
        }
        System.out.println("Beauty in BF: " + res);

    }

    public static void bosOA(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                res += (max - min);
            }
        }

        // return res;

        System.out.println("Beauty in OA: " + res);
    }
}
