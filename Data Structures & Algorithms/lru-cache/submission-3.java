class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (capacity == map.size()) {
            Node lru = tail.prev;
            remove(lru);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
    }

    private void insert(Node node) {

        map.put(node.key, node);

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }
}