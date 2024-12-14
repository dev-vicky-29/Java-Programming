import java.util.TreeMap;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long totalSubarrays = 0;
        int left = 0;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int right = 0; right < n; right++) {
            // Add current element to the map
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);

            // Check if the range condition is violated
            while (countMap.lastKey() - countMap.firstKey() > 2) {
                // Remove nums[left] from the map
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++; // Shrink the window
            }

            // Add the number of valid subarrays ending at 'right'
            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {5, 4, 2, 4};
        System.out.println(solution.continuousSubarrays(nums1)); // Output: 8

        // Example 2
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.continuousSubarrays(nums2)); // Output: 6
    }
}
