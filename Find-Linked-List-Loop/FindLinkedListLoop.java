/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null) {
            return false;
        }
        
        ListNode pointerOne = head, pointerTwo = head;
        
        while(pointerOne.next != null && 
                (pointerTwo.next != null &&
                 pointerTwo.next.next != null
                )
             ) {
            
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next.next;
            
            if(pointerOne == pointerTwo) {
                return true;
            }
        }
        
        return false;
    }
}