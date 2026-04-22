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
    * we are given the head of a linked list with length n
    * -however it has a unique property such that each node
    *  contains an additional pointer random, which may point to
    *  another node in the list, or null
    *
    * return a deep copy of the list
    *
    * to solve this, we can split algorithm into 3 phases:
    * 1. interweave copied nodes into original list
    *
    * 2. update random pointers
    *
    * 3. separate copied nodes from original nodes
    *
    * 4. return new head
    */
    public Node copyRandomList(Node head) {
        // return null if head is null
        if(head == null) return null;

        // interweave copied nodes into original list
        Node curr = head;

        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // update random pointers
        curr = head;

        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // separate copied nodes from original nodes
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
