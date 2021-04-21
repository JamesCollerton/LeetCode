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
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) {
            return null;
        }
        
        ListNode start = head;
        
        while(start != null && start.val == val) {
            ListNode nextNode = start.next;
            start.next = null;
            start = nextNode;
        }
        
        ListNode currentNode = start;
        
        while(currentNode != null) {
            
            ListNode nextNode = currentNode.next;
            
            if(nextNode == null) {
                return start;
            }
            
            while(nextNode != null && nextNode.val == val) {
                currentNode.next = nextNode.next;
                nextNode.next = null;
                nextNode = currentNode.next;
            }
            
            currentNode = currentNode.next;
        }
        
        return start;
    }
}