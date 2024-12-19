import java.util.Scanner;

public class Solution {
    public static int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();

        // Validate the size of the array
        if (n < 1 || n > 10) {
            System.out.println("Invalid size. n must be between 1 and 10.");
            return;
        }

        // Get the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array (0 to " + (n - 1) + "): ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < 0 || arr[i] >= n) {
                System.out.println("Invalid input. Each element must be between 0 and " + (n - 1) + ".");
                return;
            }
        }

        // Calculate the maximum number of chunks
        int result = maxChunksToSorted(arr);

        // Display the result
        System.out.println("The maximum number of chunks is: " + result);

        scanner.close();
    }
}
