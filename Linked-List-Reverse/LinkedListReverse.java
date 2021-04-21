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
    public ListNode reverseList(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }
        
        ListNode nodeA = head;
        ListNode newHead = head;
        
        while(nodeA.next != null) {
            
            ListNode nodeB = nodeA.next;
            
            nodeA.next = nodeB.next;
            nodeB.next = newHead;
            newHead = nodeB;
        }
        
        return newHead;
    }
}