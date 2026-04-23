/**
* classic design problem
*
* we are asked to design a data structure LRUCache
*
* get and put operations should run in O(1) time
*
* to solve this, we could implement helper methods and design a Node class:
* 1. implement insert and remove
*
* 2. for get:
*    -if element does not exist -> return -1
*    -otherwise: retrieve, remove, insert
*
* 3. for put:
*    -if element exists -> retrieve -> remove -> insert
*    -if map full -> remove tail element -> insert
*/
class LRUCache {
    // define Node class
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    // define instance variables
    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    // inititalize instance variables
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // if element doesn't exist return -1;
        if(!cache.containsKey(key)) return -1;

        // retrieve, remove, insert
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // if element exists, retrieve, remove, insert
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insert(node);

        // check if cache full
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

    // helper to insert an element
    private void insert(Node toInsert) {
        toInsert.next = head.next;
        toInsert.prev = head;
        head.next.prev = toInsert;
        head.next = toInsert;
    }

    // helper to remove an element
    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }
}
