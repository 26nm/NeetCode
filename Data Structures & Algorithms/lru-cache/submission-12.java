/**
* a classic class design problem
*
* we are asked to design a data structure LRUCache
* -get and put operations should run in O(1) time
* -key considered used if get or put op is called on it
*
* to solve this problem, we maintain a hash map and 
* doubly linked list
*
* we can use following approach:
* 1. helper method to insert and remove
*   
* 2. to get an element:
*    -if non-existent -> return -1
*    -otherwise, retrive remove insert
*    -return value of this element
*
* 3. to insert an element:
*    -if it exists -> retrieve remove insert
*    -if full -> remove tail, update cache
*/
class LRUCache {
    // define node class
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    // define instance variables
    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    // init instance variables
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // if element does not exist return -1;
        if(!cache.containsKey(key)) return -1;

        // get, remove, insert
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // if it exists, get remove insert
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insert(node);

        // otherwise, if full, remove tail element, then add new one
        } else {
            if(cache.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
        }
    }

    // insert an element
    private void insert(Node toInsert) {
        toInsert.next = head.next;
        toInsert.prev = head;
        head.next.prev = toInsert;
        head.next = toInsert;
    }

    // remove an element
    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }
}
