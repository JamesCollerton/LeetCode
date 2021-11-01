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
        
        ListNode node = head;
        
        while(node != null) {
            
            ListNode firstNode = node;
            
            while(node != null && firstNode.val == node.val) {
                node = node.next;   
            }
            firstNode.next = node;
        }
        
        return head;
    }
}