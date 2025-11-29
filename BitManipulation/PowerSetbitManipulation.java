package BitManipulation;

import java.util.ArrayList;
import java.util.List;
//tc-> N*2^n. sc->N*2^n
public class PowerSetbitManipulation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3};
        int num = 1 << (arr.length);
        List<List<Integer>> finalList = new ArrayList<>();
        System.out.printf("Number of subsets :%d ", num);
        System.out.println();
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            finalList.add(list);
        }
        System.out.println(finalList);
    }
}
