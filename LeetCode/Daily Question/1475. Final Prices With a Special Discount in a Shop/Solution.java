import java.util.Scanner;

public class Solution {
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = prices[i]; // Default value is the original price
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: size of the array
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        // Input: prices array
        int[] prices = new int[n];
        System.out.println("Enter the prices of the items:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Compute final prices
        int[] finalPrices = finalPrices(prices);

        // Output: final prices
        System.out.println("Final prices after applying discounts:");
        for (int price : finalPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }
}
