public class Solution {
    public static int addEvenNumbers(int n) {
         int sum = 0;
        for (int i = 2; i <= n; i += 2) { // Iterate through even numbers only
            sum += i; // Add the even number to the sum
        }
        return sum; // Return the final sum
    }
}