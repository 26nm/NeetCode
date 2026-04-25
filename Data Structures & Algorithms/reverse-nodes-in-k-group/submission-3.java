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
    * reverse first k nodes in linked list, reverse next k nodes, so on
    * -if fewer than k nodes left, leave nodes as they are
    *
    * return modified list after reversing nodes in each group of k
    *
    * to solve this, we can use following approach:
    * 1. create a dummy node
    *
    * 2. define left boundary
    *
    * 3. while true:
    *    -find the kth node (if null -> BREAK)
    *    -right boundary -> next of kth node
    *    -reverse group
    *    -reconnect left boundary
    *
    * 4. return dummy.next
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // define left boundary
        ListNode groupPrev = dummy;

        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;

            // define right boundary
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

        return dummy.next;
    }

    /**
    * helper to position curr to kth node
    */
    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
