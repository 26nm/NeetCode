class LRUCache {
    /**
    * design a data structure LRUCache, in which get
    * and put operations run in O(1) time
    *
    * to solve this problem, we can use HashMap and doubly
    * linked list
    *
    * 1. implement insert and removal functions first
    *
    * 2. to get an element:
    *    -if it doesn't exist return -1
    *    -retrieve, remove, insert, return value
    *
    * 3. to put an element:
    *    -if it exists, retrieve, remove, insert
    *    -otherwise, if map full: remove tail element entirely
    *    -then insert new node
    */

    class Node {
        int key, value;
        Node next, prev;
        Node (int k, int v) { key = k; value = v;}
    }

    // define instance variables
    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        // init instance variables
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // if element does not exist, return -1
        if(!cache.containsKey(key)) return -1;

        // otherwise, retrieve, remove, insert
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

        // otherwise check if map full
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

    // insert a node
    private void insert(Node toInsert) {
        toInsert.next = head.next;
        toInsert.prev = head;
        head.next.prev = toInsert;
        head.next = toInsert;
    }

    // remove a node
    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }
}
