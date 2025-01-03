import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

// Static variables to hold breadth and height
    static int B;
    static int H;
    static boolean flag;

    // Static block for initialization
    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        scanner.close();

        // Check if breadth and height are positive
        if (B > 0 && H > 0) {
            flag = true;
        } else {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

