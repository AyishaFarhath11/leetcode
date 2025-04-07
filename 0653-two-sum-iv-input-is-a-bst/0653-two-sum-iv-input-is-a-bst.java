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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BST l=new BST(root,false);
        BST r=new BST(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}
public class BST{
    private Stack<TreeNode> st=new Stack<TreeNode>();
    boolean reverse=true;
    public BST(TreeNode root, boolean isrev){
        reverse=isrev;
        pushAll(root);
    }
  

    public int next(){
        TreeNode temp=st.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse==true){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
    }
    }