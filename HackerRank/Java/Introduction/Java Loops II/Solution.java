import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
        
        int sum = a; // Initialize sum with 'a'
            for (int j = 0; j < n; j++) {
                sum += (int) Math.pow(2, j) * b; // Add 2^j * b to the sum
                System.out.print(sum + " "); // Print the current term
            }
            System.out.println(); // Move to the next line for the next query
        }
        in.close();
    }
}