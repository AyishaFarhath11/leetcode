/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         helper(root);
        return root;
    }
      public void helper(Node node){
        if(node == null || node.left == null) return;
        // not checking for node.right because it is given perfect binary tress

        node.left.next = node.right;
        if(node.next != null) node.right.next = node.next.left; //node.next will having left for sure because it is perfect binary tree so every oarent has two children for sure and node.next is definitely a parent as it is on t the level of parent of other child

        helper(node.left);
        helper(node.right);
    }
}