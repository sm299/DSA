package BitManipulation;

public class FindTwoUniqueNums {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 4, 5, 3, 4, 5, 11 , 6};
        int xor = 0;
        int n;
        for (int i : arr) {
            xor ^= i;
        }
        int rightMostSetBit = xor & -xor;//-xor is basically 2's complement,which gives last set bit
        int x = 0;
        int y = 0;
        //divide the numbers in two bucket
        for (int i : arr) {
            if ((i & rightMostSetBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        System.out.println("Numbers are "+x+" "+y);
    }
}
