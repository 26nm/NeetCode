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
    * we are given heads of two sorted linked lists list1 and list2
    *
    * merge the two lists into one sorted linked list and return
    * head of new sorted linked list
    *
    * to solve this, we might iterate through either list until
    * we reach a null node:
    * 1. declare curr1 as head of list1 and curr2 as head of list2
    *
    * 2. declare next1 as curr1.next and next2 as curr2.next
    *
    * 3. while curr1 not null or curr2 not null:
    *    -update values as needed
    *    -update links as needed
    *
    * 4. return head
    *
    * hmmm... shouldn't we determine which linked list is longer
    * first? we ought to know which linked list is longer...
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // init variables
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // merge values until null node reached in both lists
        while(list1 != null && list2 != null) {
            // link node to list1's values if smaller than list2
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;

            // link node to list2's values if smaller than list1
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        // attach remaining nodes
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}