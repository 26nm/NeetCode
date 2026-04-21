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
    * it's generally ordered in ascending
    *
    * re-arrange linked list to have following pattern:
    * [0, n-1, 1, n-2, 2, n-3, 3, ...]
    *
    * to solve this, we can split algorithm into 3 phases:
    * 1. find middle using slow and fast
    * 
    * 2. reverse right-half of linked list
    *
    * 3. merge halves alternately
    */
    public void reorderList(ListNode head) {
        // check if head is empty or has only 1 element
        if(head == null || head.next == null) return;

        // find middle with slow and fast
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right half of linked list
        ListNode prev = null, curr = slow.next;
        slow.next = null;

        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // merge halves alternately
        ListNode first = head;
        ListNode second = prev;

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
