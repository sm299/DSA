package BitManipulation;

public class SetTheIthBit {
    public static void main(String args[]) {
        int num = 9;
        int i = 10;
        int result = (num | (1 << i));
        System.out.println(result);
    }
}
