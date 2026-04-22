/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /**
    * we are given the head of a linked list of length n
    * -however, a unique property of this linked list is
    *  that it contains an additional pointer random, which 
    *  may point to another node in the list, or null
    *
    * create a deep copy of the list
    *
    * to solve this, we could use a 3-phase approach:
    * 1. interweave each new node in the list
    *
    * 2. assign random pointers
    *
    * 3. separate both lists
    */
    public Node copyRandomList(Node head) {
        // check if head is null
        if(head == null) return null;

        // interweave nodes
        Node curr = head;

        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // assign random pointers
        curr = head;

        while(curr != null) {
            // assign random for curr's next to curr's random's next
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            // advance curr (skip over existing nodes)
            curr = curr.next.next;
        }

        // separate lists
        curr = head;
        Node newHead = head.next;

        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;

            if(copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return newHead;
    }
}
