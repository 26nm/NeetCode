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
    * we are given beginning of a linked list head
    *
    * return true if a cycle in linked list exists
    * -a cycle is in a linked list if at least one
    *  node can be visited again by following next
    *  pointer
    */
    public boolean hasCycle(ListNode head) {
        // init variables
        ListNode slow = head;
        ListNode fast = head;

        // advance slow and fast until fast reaches a null state
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // check if slow and fast meet
            if(slow == fast) { return true; }
        }

        return false;
    }
}
