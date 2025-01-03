import java.util.*;

public class Solution {
    public static String canTypeSentence(String workingKeys, String sentence) {
        // Convert working keys to a set for fast lookup
        Set<Character> workingSet = new HashSet<>();
        for (char c : workingKeys.toLowerCase().toCharArray()) {
            workingSet.add(c);
        }

        // Check if each character in the sentence can be typed
        for (char c : sentence.toLowerCase().toCharArray()) {
            // Ignore spaces
            if (c != ' ' && !workingSet.contains(c)) {
                return "Cannot Type";
            }
        }

        return "Can Type";
    }

    public static void main(String[] args) {
        // Example input
        String workingKeys = "helotwrdg";
        String sentence = "Hello world";

        // Check and print the result
        System.out.println(canTypeSentence(workingKeys, sentence));
    }
}
