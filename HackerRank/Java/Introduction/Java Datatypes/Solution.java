import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong(); // Read the number
                System.out.println(x + " can be fitted in:");
                
                // Check ranges for each primitive data type
                if (x >= -128 && x <= 127) {
                    System.out.println("* byte");
                }
                if (x >= -32768 && x <= 32767) {
                    System.out.println("* short");
                }
                if (x >= -2147483648L && x <= 2147483647L) {
                    System.out.println("* int");
                }
                System.out.println("* long"); // Every long fits in a long
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }

        sc.close(); // Close the scanner
    }
}
