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
    * we are given head of a linked list of length n
    * -however, it contains a unique property such that
    *  it includes an additional pointer random that could
    *  point to other nodes in the list, or null
    *
    * return a deep copy
    *
    * to solve this, we can use a 3-phase approach:
    * 1. interweave each node
    *
    * 2. update random pointers
    *
    * 3. separate copied nodes from original nodes
    *
    * 4. return result
    */
    public Node copyRandomList(Node head) {
        // return null if head is empty
        if(head == null) return null;

        // interweave each node
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
