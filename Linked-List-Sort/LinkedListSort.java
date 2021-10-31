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
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        boolean sorted = false;
        ListNode newHead = head;
        
        while(!sorted) {
            ListNode n = newHead;
            sorted = true;
            DoubleListNode node = new DoubleListNode(newHead, null);
            while(node.node.next != null && (node.node.val > node.node.next.val)) {
                
                if(node.previous == null) {
                    newHead = node.node.next;
                } else {
                    node.previous.next = node.node.next;
                }
                
                ListNode previous = node.node.next;
                ListNode temp = node.node.next.next;
                node.node.next.next = node.node;
                node.node.next = temp;
                
                node = new DoubleListNode(node.node, previous);
                sorted = false;
            }
        }
        
        return newHead;
    }
    
    private class DoubleListNode {
        ListNode node;
        ListNode previous;
        
        DoubleListNode(ListNode node, ListNode previous) {
            this.node = node;
            this.previous = previous;
        }
    }
}