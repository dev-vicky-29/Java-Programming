import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {
        // Create a set to keep track of the elements we have seen so far
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // Check if either the double of num or half of num exists in the set
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current element to the set
            seen.add(num);
        }
        
        return false;
    }
}
