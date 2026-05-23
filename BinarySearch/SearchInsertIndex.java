package BinarySearch;

public class SearchInsertIndex {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 0, 0, 2, 3, 4, 5, 6, 7 };
        int target = 1;
        int target2 = 6;
        System.out.println("Serach Index: " + searchInd(target, nums));
        System.out.println("Serach Index: " + searchInd(target2, nums));
    }

    public static int searchInd(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ind = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ind = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ind;
    }
}
