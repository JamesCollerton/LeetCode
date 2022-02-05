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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode newHead = new ListNode(0);
        
        while(current != null) {
                        
            ListNode currentNext = current.next;
            current.next = null;
            
            ListNode previous = newHead;
            ListNode next = newHead.next;
            
            while(next != null && current.val > next.val) {
                previous = next;
                next = next.next;
            }
            
            if(next == null) {
                previous.next = current;
            } else {
                previous.next = current;
                current.next = next;
            }
            
            current = currentNext;
        }
        
        return newHead.next;
    }
}