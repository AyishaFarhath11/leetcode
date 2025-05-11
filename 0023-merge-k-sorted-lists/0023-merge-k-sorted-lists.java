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
    public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) {
            return null;
        }

        // Use a priority queue to keep track of the smallest element across the lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Dummy node to build the result list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Extract the smallest node from the priority queue and add it to the result list
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            // If there are more nodes in the list, add the next node to the priority queue
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}