/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
         Stack<Integer> st = new Stack<>(); // Stack to hold indices of the nodes
    ArrayList<Integer> list = new ArrayList<>(); // ArrayList to store node values
    ListNode temp = head; // Temporary pointer to traverse the linked list
    
    // Step 1: Convert the linked list to an ArrayList for easy access by index
    while (temp != null) {
        list.add(temp.val); // Add the node's value to the list
        temp = temp.next; // Move to the next node
    }
    
    int[] ans = new int[list.size()]; // Array to store the answer
    for (int i = 0; i < list.size(); i++) { // Step 2: Traverse the list by index
        // Step 3: Pop elements from the stack if the current element is larger
        while (!st.isEmpty() && list.get(i) > list.get(st.peek())) {
            ans[st.pop()] = list.get(i); // Set the answer for the popped index
        }
        st.push(i); // Push the current index onto the stack
    }
    
    // Step 4: Return the final answer array
    return ans;
    }
}