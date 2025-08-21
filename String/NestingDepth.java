package String;

public class NestingDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Depth : " + nD(s));
    }

    public static int nD(String s) {
        int result = 0;
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}
