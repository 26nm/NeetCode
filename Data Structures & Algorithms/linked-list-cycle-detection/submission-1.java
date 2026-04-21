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
    * return true if a cycle exists in linked list
    *
    * a cycle is said to exist within a linked list
    * if it can be visited again by following the
    * next pointer
    *
    * to solve this, we can use a fast and slow pointer:
    * 1. set both fast and slow to the head
    *
    * 2. while fast is not yet null:
    *    -advance slow to slow's next
    *    -advance fast to fast's next next
    *    -if they meet, return true
    *
    * 3. return false
    */ 
    public boolean hasCycle(ListNode head) {
        // init variables
        ListNode slow = head;
        ListNode fast = head;

        // advance while fast not yet null
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // check if fast and slow meet
            if(slow == fast) { return true; }
        }

        return false;
    }
}
