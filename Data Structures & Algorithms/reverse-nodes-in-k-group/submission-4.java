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
    * we are given head of singly linked list head and positive int k
    * -reverse first k nodes in linked list, and then reverse next k nodes
    * -if fewer than k nodes left, leave as is
    *
    * return modified list after reversing nodes in each group of k
    *
    * to solve this question, we can reverse nodes in groups:
    * 1. implement a helper to position curr to kth node
    *
    * 2. use a dummy node
    *
    * 3. define left boundary
    *
    * 4. while true:
    *    -get the kth node(if null -> BREAK)
    *    -set right boundary as next of kth
    *    -set prev to groupNext
    *    -set curr to groupPrev.next
    *    -reverse this group
    *    -reconnect left boundary
    *
    * 5. return dummy.next
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // define left boundary
        ListNode groupPrev = dummy;

        // iterate while true
        while(true) {
            // get kth node
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
