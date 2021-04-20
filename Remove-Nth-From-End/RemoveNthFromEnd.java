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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(n <= 0) {
            return head;
        }
        
        if(head == null) {
            return head;
        }
        
        if(head.next == null && n == 1) {
            return null;
        }
        
        ListNode pointerOne = head, pointerTwo = head;
        
        n += 1;
        
        while(pointerOne != null) {
            
            System.out.println("Pointer one " + pointerOne.val);
            System.out.println("Pointer two " + pointerTwo.val);
            System.out.println("N " + n);
            
            pointerOne = pointerOne.next;
            
            if(n <= 0) {
                pointerTwo = pointerTwo.next;
            }
            
            n--;
            
            if(pointerOne == null) {
                if(n <= 0){
                    if(pointerTwo.next != null) {
                        if(pointerTwo.next.next != null) {
                            pointerTwo.next = pointerTwo.next.next;
                            // pointerTwo.next.next = null;
                        } else {
                            pointerTwo.next = null;
                        }
                    }
                }
                if(n == 1) {
                    return head.next;
                }
            }
        }
        
        return head;
    }
}