import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Loop through each level of the staircase
        for (int i = 1; i <= n; i++) {
            // Print spaces first
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Print hash symbols (#)
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            // Move to the next line
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
