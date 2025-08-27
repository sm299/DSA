package String;

public class CountSubStr {
    public static void main(String[] args) {
        String s = "Shreya";
        countOfSubStr(s);
    }

    public static void countOfSubStr(String s) {
        int n = s.length();
        System.out.println("No of SubStrings : " + n * (n + 1) / 2);
    }
}
