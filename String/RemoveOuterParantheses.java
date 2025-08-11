package String;

public class RemoveOuterParantheses {
    public static void main(String[] args) {
        String s = "(())()(())";
        System.out.println(removed(s));
    }

    public static String removed(String s) {
        String[] arr = s.split("");
        String result = "";
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase("(")) {
                if (count > 0) {
                    result = result.concat(arr[i]);
                }
                count++;
            } else if (arr[i].equalsIgnoreCase(")")) {
                count--;
                if (count > 0) {
                    result = result.concat(arr[i]);
                }
            }

        }

        return result;
    }

}
