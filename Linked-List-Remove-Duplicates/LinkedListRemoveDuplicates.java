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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode newHead = head;
        ListNode node = head;
        ListNode previousNode = null;
        
        while(node != null) {
            
            if(node.next != null && node.val == node.next.val) {
                
                node = skipCycles(node);
                
                if(previousNode != null) {
                    previousNode.next = node;
                    previousNode = node;
                } else {
                    newHead = node;
                }
                
            } else {
                previousNode = node;
                node = node.next;
            }
        }
        
        return newHead;
    }
    
    private ListNode skipCycles(ListNode node) {
        if(node != null && node.next != null && node.val == node.next.val) {
            while(node.next != null && node.val == node.next.val) {
                node = node.next;
            }
            return skipCycles(node.next);
        } 
        return node;
    }
}