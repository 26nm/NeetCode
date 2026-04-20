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
    * an introduction to linked lists
    *
    * we are given a singly linked list
    *
    * return new beginning of list
    *
    * input: [0, 1, 2, 3]
    * output: [3, 2, 1, 0]
    *
    * to solve this, we look at the current node
    */
    public ListNode reverseList(ListNode head) {
        // init variables
        ListNode prev = null;
        ListNode curr = head;

        // iterate until null node reached
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
