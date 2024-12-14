import java.util.PriorityQueue;

public class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max heap to prioritize the largest pile of gifts
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        // Add all gift piles to the max heap as long values
        for (int gift : gifts) {
            maxHeap.add((long) gift);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                long maxGift = maxHeap.poll(); // Get the largest pile
                long remainingGifts = (long) Math.floor(Math.sqrt(maxGift)); // Leave behind floor of sqrt
                maxHeap.add(remainingGifts); // Add the remaining back to the heap
            }
        }

        // Calculate the sum of all remaining gifts
        long totalRemainingGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalRemainingGifts += maxHeap.poll();
        }

        return totalRemainingGifts;
    }

    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();

        int[] gifts1 = {25, 64, 9, 4, 100};
        int k1 = 4;
        System.out.println(solution.pickGifts(gifts1, k1)); // Output: 29

        int[] gifts2 = {1, 1, 1, 1};
        int k2 = 4;
        System.out.println(solution.pickGifts(gifts2, k2)); // Output: 4

        int[] gifts3 = {411042986, 697316006, 569259488, 665293106, 728558122, 395308016};
        int k3 = 630;
        System.out.println(solution.pickGifts(gifts3, k3)); // Output: Expected large result without overflow
    }
}
