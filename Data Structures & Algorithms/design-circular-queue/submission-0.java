class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    ListNode(int val, ListNode next, ListNode prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularQueue {

    private ListNode left;
    private ListNode right;
    private int space;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.space = k;
        left = new ListNode(0,null,null);
        right = new ListNode(0,null,left);
        left.next = right; 
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        ListNode node = new ListNode(value, this.right, this.right.prev);
        this.right.prev.next = node;
        this.right.prev = node;
        this.space--;

        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
    
        this.left.next = this.left.next.next;
        this.left.next.prev = this.left;
        this.space++;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty()){
            return -1;
        }
        return this.left.next.val;
    }
    
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        return this.right.prev.val;
    }
    
    public boolean isEmpty() {
        return space == capacity;
    }
    
    public boolean isFull() {
        return space == 0;
    }
}