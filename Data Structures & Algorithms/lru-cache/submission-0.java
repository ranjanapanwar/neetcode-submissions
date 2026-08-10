class Node {
    private int key;
    private int val;
    private Node next;
    private Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer,Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node tmp = this.right.prev;
        node.next = this.right;
        this.right.prev = node;
        node.prev = tmp;
        tmp.next = node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node tmp = cache.get(key);
        remove(tmp);
        insert(tmp);
        return tmp.val;
    }
    
    public void put(int key, int value) {
       if(cache.containsKey(key)) {
            remove(cache.get(key));
       }

       Node node = new Node(key, value);
       cache.put(key, node);
       insert(node);

       if(cache.size() > capacity){
        Node tmp = this.left.next;
        remove(tmp);
        cache.remove(tmp.key);
       }
        

        
    }
}
