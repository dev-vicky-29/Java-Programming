import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
     // Extract the time period (AM/PM) and time parts
        String period = s.substring(8);
        String timePart = s.substring(0, 8);
        
        // Split the time into hours, minutes, and seconds
        int hours = Integer.parseInt(s.substring(0, 2));
        String minutes = s.substring(3, 5);
        String seconds = s.substring(6, 8);
        
        // Convert hours based on the period
        if (period.equals("AM")) {
            // Special case for midnight
            if (hours == 12) {
                hours = 0;
            }
        } else if (period.equals("PM")) {
            // Special case for noon
            if (hours != 12) {
                hours += 12;
            }
        }
        
        // Format the hours as two digits
        String formattedHours = String.format("%02d", hours);
        
        // Combine into the 24-hour format
        return formattedHours + ":" + minutes + ":" + seconds;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
