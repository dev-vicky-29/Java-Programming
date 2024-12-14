import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // Initial operation is addition
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            // If the character is an operator or the end of the string, process the operation
            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                switch (operation) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }
                operation = ch; // Update the current operation
                currentNumber = 0; // Reset the current number
            }
        }

        // Sum up all values in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression:");
        String s = scanner.nextLine(); // Input the expression from the user

        Solution calculator = new Solution();
        int result = calculator.calculate(s);

        System.out.println("Result: " + result);
        scanner.close();
    }
}
