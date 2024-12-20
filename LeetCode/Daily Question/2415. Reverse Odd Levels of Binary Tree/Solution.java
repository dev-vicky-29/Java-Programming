/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        // Use a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oddLevel = false; // Track whether we are at an odd level

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                // Add children to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse the values at odd levels
            if (oddLevel) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            // Toggle oddLevel for the next level
            oddLevel = !oddLevel;
        }

        return root;
    }
}
