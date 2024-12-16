import java.util.*;

public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            // Find the index of the minimum value
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Multiply the minimum value by the multiplier
            nums[minIndex] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Input multiplier
        System.out.print("Enter the multiplier: ");
        int multiplier = scanner.nextInt();

        Solution solution = new Solution();
        int[] result = solution.getFinalState(nums, k, multiplier);

        // Output the final state of the array
        System.out.println("Final state of the array: " + Arrays.toString(result));

        scanner.close();
    }
}
