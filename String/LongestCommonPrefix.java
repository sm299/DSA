package String;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = { "flower", "flood", "flight" };
        String[] arr1 = { "Zoo", "Jute", "Juvenile" };
        lcp(arr);
        lcp(arr1);

        System.out.println(longestCommonPrefix(arr));
    }

    public static void lcp(String[] strs) {

        if (strs == null || strs.length == 0)
            System.out.println("blank array");
        if (strs.length == 1)
            System.out.println("Only one element is there");

        String result = strs[0];

        int x = result.length() - 1;
        for (int j = 1; j < strs.length; j++) {
            int k = 0;
            while (k < Math.min(strs[j].length(), result.length())) {
                if (strs[j].charAt(k) == result.charAt(k)) {
                    k++;
                } else {
                    break;
                }
            }
            x = k - 1;
        }
        if (x > 0) {
            System.out.println("Common part : ");
            System.out.print(result.substring(0, x + 1));

        } else {
            System.out.print("Nothing in common");
        }
        System.out.println();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0]; // start with first string

        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until current string starts with it
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }
}
