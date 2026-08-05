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
    public Node copyRandomList(Node head) {
          Map<Node,Node> copyMap = new HashMap<Node,Node>();
          Node curr = head;
          while(curr != null){
               Node copy = new Node(curr.val);
               copyMap.put(curr, copy);
               curr = curr.next;
          }

          curr = head;
          while(curr != null){
               Node copyNode = copyMap.get(curr);
               copyNode.next = copyMap.get(curr.next);
               copyNode.random = copyMap.get(curr.random); 
               curr = curr.next;
          }

          return copyMap.get(head);
        
    }
}
