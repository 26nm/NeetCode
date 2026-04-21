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
    * we are given the heads of two sorted linked lists list1 and list2
    *
    * merge the two lists into one sorted linked list and return the head of the new
    * sorted linked list
    *
    * to solve this, we might use a dummy node and two pointers:
    * 1. init variables
    *
    * 2. while list1 is not null and list2 is not null:
    *    -if list1's value's smaller than list2's values, link to list1
    *    -otherwise link to list2
    *    -update curr to curr.next
    *
    * 3. update curr to curr.next, depending on which list not null yet
    *
    * 4. return dummy.next
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // init variables
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // loop while list1 or list2 not null yet
        while(list1 != null && list2 != null) {
            // link dummy to list1 if smaller than list2
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;

            // link dummy to list2 if smaller than list1
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}