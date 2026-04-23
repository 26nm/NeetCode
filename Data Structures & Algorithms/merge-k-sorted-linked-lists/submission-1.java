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
    * we are given an array of k linked lists lists, where each list is sorted
    * in ascending order
    *
    * return sorted linked list containing all merged linked lists
    *
    * to solve this, we can maintain a priority queue (min heap):
    * 1. add all heads to the min heap if not null
    *
    * 2. use a dummy node
    *
    * 3. while the heap is not empty:
    *    -extract smallest node, store in new node
    *    -set current's next to this
    *    -set current to this
    *    -if this node has a non-null next, throw it in heap
    *
    * 4. return dummy.next
    */
    public ListNode mergeKLists(ListNode[] lists) {
        // init variables
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add heads to min heap if not null
        for(ListNode node : lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }

        // use a dummy node
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // extract smallest nodes from heap while not empty
        while(!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            // check if this node has a non-null next
            if(smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
