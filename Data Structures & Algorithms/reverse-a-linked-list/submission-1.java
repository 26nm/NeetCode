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
    * a classic introduction to linked lists
    *
    * we are given a singly linked list head
    *
    * reverse the list, return new beginning of list
    *
    * to solve this, we could:
    * 1. make a node to store the next of current
    *
    * 2. set next of current to previous node
    *
    * 3. set previous node to the current
    *
    * 4. set current to the new node
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
