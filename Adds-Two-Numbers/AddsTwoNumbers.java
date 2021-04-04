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
        return addTwoNumbersWithCarry(l1, l2, 0);
    }
    
    public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null) {
            if(carry != 0) {
                return new ListNode(carry, null);
            }
            return null;
        }
        
        if(l1 == null) {
            int sum = l2.val + carry;
            int newNodeValue = sum % 10;
            int newCarry = sum >= 10 ? 1: 0;
            return new ListNode(newNodeValue, addTwoNumbersWithCarry(null, l2.next, newCarry));
        }
        if(l2 == null) {
            int sum = l1.val + carry;
            int newNodeValue = sum % 10;
            int newCarry = sum >= 10 ? 1: 0;
            return new ListNode(newNodeValue, addTwoNumbersWithCarry(l1.next, null, newCarry));
        }
        int sum = l1.val + l2.val + carry;
        int newNodeValue = sum % 10;
        int newCarry = sum >= 10 ? 1: 0;
        return new ListNode(newNodeValue, addTwoNumbersWithCarry(l1.next, l2.next, newCarry));
    }
}