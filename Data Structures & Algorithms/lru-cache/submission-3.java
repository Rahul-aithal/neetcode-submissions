class Node {
    int value;
    int key;
    Node next;
    Node prev;
    public Node(int value, int key, Node next, Node prev) {
        this.value = value;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
    public Node(int val, int key) {
        this.value = val;
        this.key = key;
    }
    public Node() {}
}

class LRUCache {
    Node cacheHead = new Node();
    Node cacheTail = new Node();
    HashMap<Integer, Node> map = new HashMap<>();
    int maxCapacity = 0;
    int currentCapacity = 0;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currentCapacity = 0;

        this.cacheHead.next = this.cacheTail;
        this.cacheTail.prev = this.cacheHead;
    }
    void addFirst(Node n) {
        Node next = this.cacheHead.next;
        this.cacheHead.next = n;
        n.prev = this.cacheHead;
        n.next = next;
        next.prev = n;
        // System.out.println("First value " + n.value + " got inserted");
    }
    Node removeLast() {
        Node n = this.cacheTail.prev;
        Node prev = n.prev;
        prev.next = this.cacheTail;
        this.cacheTail.prev = prev;
        int val = n.value;
        // System.out.println("Last key-value " +n.key +"-"+ val + " got removed");
        n.value = -1;
        this.map.remove(n.key);
        return n;
    }
    public int get(int key) {
        if (!this.map.containsKey(key))
            return -1;

        Node n = this.map.get(key);
        this.map.remove(key);
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        addFirst(n);
        this.map.put(key, n);
        return n.value;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node n = this.map.get(key);
            this.map.remove(key);
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;
            n.value = value;
            addFirst(n);
            this.map.put(key, n);
            return;
        }
        if (this.currentCapacity == this.maxCapacity) {
            removeLast();
            currentCapacity--;
        }
        Node n = new Node(value, key);
        addFirst(n);
        map.put(key, n);
        currentCapacity++;
        return;
    }
}
