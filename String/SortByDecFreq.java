package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByDecFreq {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println("BF : " + sbdfBF(s));
    }

    public static String sbdfBF(String s) {
        Map<Character, Integer> mapInit = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapInit.put(s.charAt(i), mapInit.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(mapInit.entrySet());
        entries.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey().compareTo(b.getKey()); // lexicographically if same frequency
            }
            return b.getValue() - a.getValue(); // by frequency descending
        });

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
