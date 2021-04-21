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
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode reverseSecondHalf = null;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
            
        if(fast == null) {
            reverseSecondHalf = reverseList(slow);
        } else {
            reverseSecondHalf = reverseList(slow.next);
        }
        
        fast = head;
        
        while(reverseSecondHalf != null) {
            if(reverseSecondHalf.val != fast.val) {
                return false;
            }
            reverseSecondHalf = reverseSecondHalf.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        
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