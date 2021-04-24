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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) {
            return null;
        }
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode head = null;
        ListNode lastNode = null;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        
        while(!(l1Pointer == null && l2Pointer == null)) {
            int nextVal;
            if(l1Pointer == null || (l2Pointer != null && l1Pointer.val > l2Pointer.val)) {
                nextVal = l2Pointer.val;
                l2Pointer = l2Pointer.next;
            } else {
                nextVal = l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }
            if(lastNode == null) {
                ListNode newNode = new ListNode(nextVal, null);
                head = newNode;
                lastNode = newNode;
            } else {
                ListNode newNode = new ListNode(nextVal, null);
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        
        
        return head;
    }
}