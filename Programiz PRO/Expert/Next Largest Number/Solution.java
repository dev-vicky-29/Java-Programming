import java.util.*;

public class Solution {
    public static int nextLargestNumber(int n) {
        // Convert the number to a character array of digits
        char[] digits = String.valueOf(n).toCharArray();
        
        // Step 1: Find the first decreasing digit from the end
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        // If no such digit is found, the digits are in descending order
        if (i < 0) {
            return -1; // No larger number can be formed
        }
        
        // Step 2: Find the smallest digit on the right side of 'i' that is larger than digits[i]
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        
        // Step 3: Swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
        
        // Step 4: Reverse the digits after position i
        reverse(digits, i + 1, digits.length - 1);
        
        // Convert the character array back to an integer
        return Integer.parseInt(new String(digits));
    }
    
    // Helper function to reverse a part of the array
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
