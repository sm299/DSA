package Arrays;

//time complexity(brute force)-> O(nlogn)
//space complexity(brute force)-> O(1)
//time complexity(optimal)->O(n)
//space complexity(optimal)->O(1)
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 2 };
        System.out.println(largest(arr));
        // this is optimal as brute force is sorting the array and print the last
        // element
    }

    public static int largest(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
