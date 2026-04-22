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
    * we are given head of linked list with length n
    * -however, unlike singly linked list, each node contains
    *  additional pointer random, which may point to null or
    *  any node in the list
    *
    * create a deep copy of the list
    *
    * i'm not really sure what to do...
    *
    * especially since we do not have a copy constructor for the node...
    */
    public Node copyRandomList(Node head) {
        // check if head empty
        if(head == null) return null;

        // init variables
        Node curr = head;

        // interweave nodes
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // assign random pointers
        curr = head;

        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

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
