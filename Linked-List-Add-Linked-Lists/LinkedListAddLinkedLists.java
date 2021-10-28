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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode reversedListOne = reverseList(l1);
        ListNode reversedListTwo = reverseList(l2);
                        
        ListNode onePointer = reversedListOne;
        ListNode twoPointer = reversedListTwo;
        ListNode head = null;
        ListNode previousNode = null;
        int carry = 0;
        
        while(onePointer != null || twoPointer != null) {
                        
            int value;
            
            if(onePointer == null) {
                value = twoPointer.val + carry;
            } else if(twoPointer == null) {
                value = onePointer.val + carry;
            } else {
                value = onePointer.val + twoPointer.val + carry;
            }
            
            int units = value % 10;
            carry = value / 10;
            
            ListNode listNode = new ListNode(units);
            
            if(previousNode != null) {
                previousNode.next = listNode;
            } else {
                head = listNode;
            }
            
            previousNode = listNode;
            if(onePointer != null) {
                onePointer = onePointer.next;
            }
            if(twoPointer != null) {
                twoPointer = twoPointer.next;
            }
        }
        
        if(carry != 0) {
            ListNode listNode = new ListNode(carry);
            previousNode.next = listNode;
        }
        
        return reverseList(head);
    }
    
    private ListNode reverseList(ListNode head) {
        
        ListNode previous = null;
        ListNode node = head;
        
        while(node != null) {
            ListNode temp = node.next;
            node.next = previous;
            previous = node;
            node = temp;
        }
        
        return previous;
    }
}
