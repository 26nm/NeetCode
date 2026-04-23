class LRUCache {
    /**
    * define a Node class
    */
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    // define instance variables
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    // init variables
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    // retrieve element at given key
    public int get(int key) {
        // if element does not exist, return -1
        if(!cache.containsKey(key)) return -1;

        // retrieve, remove, reinsert, return value of retrieved node  
        Node retrieve = cache.get(key);
        remove(retrieve);
        insert(retrieve);
        return retrieve.value;
    }
    
    // insert into cache
    public void put(int key, int value) {
        // if element exists, retrieve, remove, and reinsert
        if(cache.containsKey(key)) {
            Node retrieve = cache.get(key);
            retrieve.value = value;
            remove(retrieve);
            insert(retrieve);

        // otherwise check if map full first, then insert
        } else {
            // if cache full, remove tail element 
            if(cache.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            // finally, insert element into cache
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
        }
    }

    // reassign pointers adjacent to target
    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }

    // assign node-to-be-inserted's previous and next, and head's pointers
    private void insert(Node toInsert) {
        toInsert.next = head.next;
        toInsert.prev = head;
        head.next.prev = toInsert;
        head.next = toInsert;
    }
}
