import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;  // Pointer to track spaces array

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {
            // If we are at an index where a space is to be added
            if (spaceIndex < spaces.length && spaces[spaceIndex] == i) {
                result.append(" ");  // Add space
                spaceIndex++;  // Move to the next space index
            }
            result.append(s.charAt(i));  // Add current character of s
        }

        return result.toString();  // Return the final string with spaces added
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the string input
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        // Get the spaces array input
        System.out.print("Enter the spaces indices (comma-separated): ");
        String spacesInput = scanner.nextLine();
        // Split the input string into an array of integers
        String[] spacesStr = spacesInput.split(",");
        int[] spaces = new int[spacesStr.length];
        for (int i = 0; i < spacesStr.length; i++) {
            spaces[i] = Integer.parseInt(spacesStr[i].trim());
        }

        // Create a Solution object and call addSpaces
        Solution solution = new Solution();
        String result = solution.addSpaces(s, spaces);

        // Output the result
        System.out.println("Resulting string: " + result);
    }
}
