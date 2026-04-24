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
    * we are given the head of a singly linked list head and int k
    *
    * reverse the first k nodes in linked list, and then reverse next k
    * nodes
    *
    * leave nodes as they are if less than k elements
    *
    * return modified linked list after reversing nodes in each group of
    * k
    *
    * to solve this, we can reverse the nodes in chunks until we have
    * no more nodes to reverse
    * 1. use a dummy node
    *
    * 2. 
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // track previous node for group
        ListNode groupPrev = dummy;

        // loop until no more nodes to reverse
        while(true) {
            // if not enough nodes, end
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;

            // track next node for group
            ListNode groupNext = kth.next;

            // reverse group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // reconnect
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // helper to move curr to kth node
    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
