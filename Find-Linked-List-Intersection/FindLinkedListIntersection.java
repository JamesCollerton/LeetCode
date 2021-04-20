/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) {
            return null;
        }
        
        if(headA == headB) {
            return headA;
        }
        
        boolean allASeen = false, allBSeen = false;
        ListNode pointerA = headA, pointerB = headB;
        
        while(pointerA != null && pointerB != null) {
            
            pointerA = pointerA.next;
            pointerB = pointerB.next;
            
            if(pointerA == null && !allASeen) {
                pointerA = headB;
                allASeen = true;
            }
            if(pointerB == null && !allBSeen) {
                pointerB = headA;
                allBSeen = true;
            }
            
            if(pointerA == pointerB) {
                return pointerA;
            }
        }
        
        return null;
    }
}