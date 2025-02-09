/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
         if (head == null) return head;
    
    Stack<Node> stack = new Stack<>();
    stack.push(head);
    
    Node prev = new Node(0); 
    while (!stack.isEmpty()) {
        Node node = stack.pop();
        prev.next = node;
        node.prev = prev;
        prev.child = null;
        prev = node;
        
        if (node.next != null) {
            stack.push(node.next);
        }
        if (node.child != null) {
            stack.push(node.child);
        }
    }
    head.prev = null;
    return head; 
    }
}