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
    * we are given two non-empty linked lists l1 and l2
    * -each represents a non-negative int stored in reverse order
    *
    * return the sum of two numbers as a linked list
    *
    * to solve this, we can:
    * 1. iterate while a list is not yet null AND while carry exists:
    *    -extract digits from non-null lists
    *    -compute sum as x + y + carry
    *    -calculate carry as sum / 10
    *    -create new node for the next digit place
    *    -advance current 
    *    -advance l1 and l2 as needed
    *
    * 2. return the result
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // init variables
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // iterate while at least one list not null and while carry exists
        while(l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // compute sum and carries
            int sum = x + y + carry;
            carry = sum / 10;

            // create new node for next digit
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // advance l1 and l2 as needed
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
