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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        // Don't need, simplify         
        ListNode oddStart = head;
        ListNode evenStart = head.next;
        
        ListNode oddHead = head;
        
        while(oddHead != null) {
            
            ListNode evenHead = oddHead.next;
                
            if(evenHead == null) {
                oddHead.next = evenStart;
                return oddStart;
            }
                
            oddHead.next = evenHead.next;
            
            if(evenHead.next == null) {
                oddHead.next = evenStart;
                return oddStart;
            }
            
            evenHead.next = evenHead.next.next;
            
            oddHead = oddHead.next;
        }
        
        return head;
    }
}