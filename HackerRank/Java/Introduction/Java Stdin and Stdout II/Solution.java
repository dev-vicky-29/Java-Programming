import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        double d=scan.nextDouble();
        scan.nextLine(); // Consume the remaining newline character
        String s=scan.nextLine(); // Read the string (entire line)
	scan.close(); // Close the scanner

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}