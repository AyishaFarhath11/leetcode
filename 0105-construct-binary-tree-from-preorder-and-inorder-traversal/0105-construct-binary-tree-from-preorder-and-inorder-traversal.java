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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Call the helper function to build the tree
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     HashMap<Integer, Integer> inorderIndexMap) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the root in inorder to split into left and right subtrees
        int rootIndex = inorderIndexMap.get(rootVal);
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively build the left subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                                    inorder, inStart, rootIndex - 1, inorderIndexMap);

        // Recursively build the right subtree
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                                     inorder, rootIndex + 1, inEnd, inorderIndexMap);

        return root;
    }

    // Helper method to print the tree (inorder traversal)
    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}