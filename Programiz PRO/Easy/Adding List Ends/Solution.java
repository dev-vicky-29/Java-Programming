import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static int addFirstAndLast(List<Integer> list) {
        if (list.isEmpty()) { // Check if the list is empty
            return 0; // Return 0 if the list is empty
        }
        return list.get(0) + list.get(list.size() - 1); // Sum of the first and last elements
    
    }
}