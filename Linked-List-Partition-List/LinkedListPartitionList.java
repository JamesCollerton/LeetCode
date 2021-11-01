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
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        
        ListNode lessThanHead = null, moreThanHead = null;
        ListNode lessThanPrevious = null, moreThanPrevious = null;
        
        ListNode node = head;
        while(node != null) {
            if(node.val < x) {
                if(lessThanHead == null) {
                    lessThanHead = node;
                }
                if(lessThanPrevious != null) {
                    lessThanPrevious.next = node;
                }
                lessThanPrevious = node;
            } else {
                if(moreThanHead == null) {
                    moreThanHead = node;
                }
                if(moreThanPrevious != null) {
                    moreThanPrevious.next = node;
                }
                moreThanPrevious = node;
            }
            ListNode temp = node.next;
            node.next = null;
            node = temp;
        }
        
        if(lessThanPrevious != null) {
            lessThanPrevious.next = moreThanHead;
        }
        
        return lessThanHead == null ? moreThanHead : lessThanHead;
    }
}