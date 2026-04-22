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
    * we are given the beginning of linked list head, and an integer n
    *
    * remove the nth node from the end of list and return beginning of list
    *
    * to solve this, we can create an n+1 gap between fast and slow, then use
    * slow to remove the node
    * 1. make a dummy node, along with fast and slow pointers
    *
    * 2. advance fast n+1 times
    *
    * 3. advance both pointers to target node
    *
    * 4. remove target
    *
    * 5. return
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // init variables
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // create gap n + 1 wide
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // advance both pointers to target area
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
