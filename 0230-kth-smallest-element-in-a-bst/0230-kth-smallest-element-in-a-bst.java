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
    public int kthSmallest(TreeNode root, int k) {
         int[] kSmallest = new int[]{Integer.MIN_VALUE};
  
        // Counter to track visited nodes
        int[] counter = new int[]{0};

        // Find Kth smallest element
        // (perform inorder traversal)
        inorder(root, counter, k, kSmallest);
    

        return kSmallest[0];
    }
     private void inorder(TreeNode node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.val;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, counter, k, kSmallest);
    }

}