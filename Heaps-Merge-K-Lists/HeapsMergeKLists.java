/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(ListNode listNode: lists) {
                            
            ListNode node = listNode;

            while(node != null) {
                queue.add(node.val);
                node = node.next;
            }
                        
        }
        
        if(queue.isEmpty()) {
            return null;
        }
        
        ListNode head = new ListNode(queue.poll());
        ListNode node = head;
        
        while(!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            node.next = newNode;
            node = newNode;
        }
        
        return head;
    }
}