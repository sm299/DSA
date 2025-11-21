package BitManipulation;

public class ToggleIthBit {
    public static void main(String[] args) {
        int num = 13;
        int i = 2;
        int result = num ^ (1 << i);
        System.out.println(result);
    }
}
