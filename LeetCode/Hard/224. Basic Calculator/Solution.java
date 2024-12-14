import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0; // To hold the current number being processed
        int result = 0; // The ongoing result of the evaluation
        int sign = 1; // The current sign (+1 or -1)

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Build the current number
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '+') {
                // Add the current number to the result with its sign
                result += sign * currentNumber;
                currentNumber = 0; // Reset current number
                sign = 1; // Update the sign to positive
            } else if (ch == '-') {
                // Add the current number to the result with its sign
                result += sign * currentNumber;
                currentNumber = 0; // Reset current number
                sign = -1; // Update the sign to negative
            } else if (ch == '(') {
                // Push the current result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Add the current number to the result with its sign
                result += sign * currentNumber;
                currentNumber = 0;
                // Pop the sign and previous result from the stack
                result *= stack.pop(); // Multiply result by the sign before '('
                result += stack.pop(); // Add the result before '('
            }
        }

        // Add the last number (if any) to the result
        result += sign * currentNumber;
        return result;
    }

    public static void main(String[] args) {
        Solution calculator = new Solution();

        // Test cases
        System.out.println(calculator.calculate("1 + 1")); // Output: 2
        System.out.println(calculator.calculate(" 2-1 + 2 ")); // Output: 3
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
}
