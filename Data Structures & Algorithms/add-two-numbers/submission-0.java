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
    * -each represents a non-negative integer
    *
    * digits in each list are stored in reverse order
    * 
    * return sum of two numbers as linked list
    *
    * [1, 2, 3] + [4, 5, 6] -> [5, 7, 9]
    *
    * [9] + [9] -> [8, 1]
    *
    * i think we can do in-place for this to achieve O(1) space
    *
    * boundary-wise, we can iterate while both pointers are not null
    *
    * should we consider an approach where, we "interweave" the added nodes
    * like in the previous question, then separate them as well?
    *
    * the idea:
    * 1. make a new node to store the sum of values in both spots
    *    -we have to consider making a new node for carries
    * 
    * 2. separate these nodes from original nodes
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // init variables
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // iterate until a list is null or while carry exists
        while(l1 != null || l2 != null || carry != 0) {
            // extract values if lists are not null, 0 otherwise
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // compute sum and carries
            int sum = x + y + carry;
            carry = sum / 10;

            // create new node for each digit place
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // advance pointers as applicable
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
