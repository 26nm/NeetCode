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
    * we are given the head of singly linked list
    *
    * positions of a linked list of length = 7 can be initially
    * represented as
    *
    *[0, 1, 2, 3, 4, 5, 6]
    *
    * list must be reordered as:
    *
    * [0, n-1, 1, n-2, 2, n-3, ...] -> [0, 6, 1, 5, 2, 4, 3]
    *
    * do not modify values in list nodes, but reorder nodes
    *
    * [2, 4, 6, 8] -> [2, 8, 4, 6]
    *
    * [2, 4, 6, 8, 10] -> [2, 10, 4, 8, 6]
    *
    * would a fast and slow pointer be helpful here?
    * -maybe we would iterate until fast is null?
    * -but how would we know which values to rearrange?
    */
    public void reorderList(ListNode head) {
        // if list empty or has only 1, exit
        if(head == null || head.next == null) return;

        // find middle of list using slow
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right-half of list
        ListNode prev = null, curr = slow.next;
        slow.next = null;

        // reverse until current is null
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // merge halves together
        ListNode first = head;
        ListNode second = prev;

        // iterate until second is null
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
