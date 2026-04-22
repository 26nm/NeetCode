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
    * we are given beginning of linked list head and integer n
    *
    * remove nth node from end of list and return beginning of list
    *
    * remove Nth node from the end and return beginning of list
    *
    * this problem is asking us to implement removing a middle node from
    * a linked list
    *
    * [1, 2, 3, 4], n = 2 -> [1, 2, 4] (3 is 2nd element from end)
    *
    * [1, 2], n = 2 -> [2] (1 is 2nd element from list)
    *
    * it might help to use fast and slow pointers perhaps? like
    * we might have one pointer at the very end, another in the
    * middle
    *
    * from there, we just implement remove a middle node from linked list,
    * on right half of linked list
    * 1. use fast and slow to reach the end
    *
    * 2. then we move fast pointer to the left n times
    *
    * 3. then perform a removal
    *
    * 4. then return this result
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // create gap of n + 1
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // advance both pointers
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
