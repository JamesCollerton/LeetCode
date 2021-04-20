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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        ListNode previousPointerOne;
        ListNode pointerOne = head, pointerTwo = head;
        
        boolean foundLoop = false;
        
        while(pointerOne.next != null && 
                (pointerTwo.next != null &&
                 pointerTwo.next.next != null
                )
             ) {
            
            pointerOne = pointerOne.next;
            
            if(foundLoop) {
                pointerTwo = pointerTwo.next;
            } else {
                pointerTwo = pointerTwo.next.next;
            }
            
            if(pointerOne == pointerTwo && !foundLoop) {
                foundLoop = true;
                pointerTwo = head;
                if(pointerOne == pointerTwo) {
                    return head;
                }
            } else if (pointerOne == pointerTwo) {
                return pointerOne;
            }
        }
        
        return null;
        
    }
}