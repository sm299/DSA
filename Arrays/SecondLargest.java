package Arrays;

//Brute Force: time complexity:O(nlogn+n)
//Better Approach: time complexity:O(2n)
//Optimal: time complexity:O(n)
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 2, 7, 7 };
        System.out.println("Brute Force: " + secondLargestByBruteForce(arr));
        System.out.println("Better Approach: " + secondLargestByBetterApproach(arr));
        System.out.println("Optimal Approach: " + secondLargestByOptimalApproach(arr));
    }

    public static int secondLargestByBruteForce(int[] arr) {
        int secondLargest = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < arr[arr.length - 1]) {
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    public static int secondLargestByBetterApproach(int[] arr) {
        int secondLargest = -1;
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (secondLargest < arr[i] && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static int secondLargestByOptimalApproach(int[] arr) {
        int secondLargest = -1;
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
