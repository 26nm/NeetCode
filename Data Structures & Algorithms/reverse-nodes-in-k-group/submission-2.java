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
    * we are given head of singly linked list head and positive integer k
    *
    * reverse first k nodes in linked list, then reverse next k nodes, and 
    * so on
    * -if fewer than k nodes left, leave nodes as is
    *
    * return modified list after reversing nodes in each group of k
    *
    * to solve this question, we can use a helper to move curr to kth position:
    *
    * 1. set a dummy node
    *
    * 2. 
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // track left boundary for group
        ListNode groupPrev = dummy;

        // loop until no more nodes to reverse
        while(true) {
            // if kth node null, break
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;

            // track right boundary for group as next of kth
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

            // reconnect left boundary
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        // return head
        return dummy.next;
    }

    /**
    * helper to move curr to kth node
    */
    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
