import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'unboundedKnapsack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int unboundedKnapsack(int k, List<Integer> arr) {
        // Initialize dp array where dp[i] will be the maximum sum <= i
        int[] dp = new int[k + 1];
        
        // Iterate over all values from 1 to k
        for (int i = 1; i <= k; i++) {
            for (int num : arr) {
                if (i >= num) {
                    dp[i] = Math.max(dp[i], dp[i - num] + num); // Maximize the sum
                }
            }
        }
        
        return dp[k]; // Return the maximum sum that is <= k
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        while (t-- > 0) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int k = Integer.parseInt(firstMultipleInput[1]);

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            int result = Result.unboundedKnapsack(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
