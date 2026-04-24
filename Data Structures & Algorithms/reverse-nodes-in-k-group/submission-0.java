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
    * we are given the head of singly linked list head and
    * positive integer k
    *
    * reverse the first k nodes in the linked list, and then
    * reverse the next k nodes, and so on
    *
    * return modified list after reversing nodes in each group
    * of k
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // use variable to track prev for group
        ListNode groupPrev = dummy;

        // loop until no more nodes to reverse
        while(true) {
            // if not enough nodes left, end
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;

            // track next for group
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

    // helper to move curr to the kth index
    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
