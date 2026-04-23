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
    /**
    * we are given an array of k linked lists, with each list sorted
    * in ascending order
    *
    * return sorted linked list that is result of merging all individual linked lists
    *
    * maybe we'll have a slow and a fast pointer
    * and then use the same logic covered in
    * Merge Two Sorted Linked Lists?
    *
    * this would be a bit slow, though
    */
    public ListNode mergeKLists(ListNode[] lists) {
        // init variables
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add all heads
        for(ListNode node : lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }

        // use a dummy node
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // while heap not empty, extract smallest nodes
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
