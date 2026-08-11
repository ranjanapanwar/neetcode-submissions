/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        List<ListNode> currentLists = Arrays.asList(lists);
        while(currentLists.size() > 1){
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0; i<currentLists.size(); i=i+2){
                ListNode listNode1 = currentLists.get(i);
                ListNode listNode2 = i+1 < currentLists.size() ? currentLists.get(i+1) : null;
                mergedLists.add(mergeList(listNode1,listNode2));
            }
            currentLists = mergedLists;
        }

        return currentLists.get(0);
    }

    private ListNode mergeList(ListNode listNode1, ListNode listNode2){
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            while(listNode1 != null && listNode2 != null){
                if(listNode1.val < listNode2.val){
                    curr.next = listNode1;
                    listNode1 = listNode1.next;
                }else{
                    curr.next = listNode2;
                    listNode2 = listNode2.next;
                } 
                curr = curr.next ; 
            }
            

            if(listNode1 == null){
                curr.next = listNode2;
            } else {
                curr.next = listNode1;
            }
            return dummy.next;
    }
}