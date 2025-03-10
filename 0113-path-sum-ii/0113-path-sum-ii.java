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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          List<Integer> path = new ArrayList<Integer>();
        dfs(root, path, targetSum);
        return ans;
    }
     private void dfs(TreeNode node, List<Integer> path, int remainingSum) {
        // if it is null, then return
        if (node == null) return;
        // add the current node val to path
        path.add(node.val);
        // !node.left && !node.right : check if it is a leaf node
        // remainingSum == node.val: check if the remaining sum - node.val == 0
        // if both condition is true, then we find one of the paths
        if (node.left == null && node.right == null && remainingSum == node.val) ans.add(new ArrayList<>(path));
        // traverse left sub tree with updated remaining sum
        // we don't need to check if left sub tree is nullptr or not
        // as we handle it in the first line of this function
        this.dfs(node.left, path, remainingSum - node.val);
        // traverse right sub tree with updated remaining sum
        // we don't need to check if right sub tree is nullptr or not
        // as we handle it in the first line of this function
        this.dfs(node.right, path, remainingSum - node.val);
        // backtrack 
        path.remove(path.size() - 1);
    }
}