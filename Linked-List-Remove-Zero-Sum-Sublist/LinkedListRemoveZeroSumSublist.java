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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode newHead = head;
        ListNode p0 = null;
        ListNode p1 = head;
        ListNode p2 = head;
        
        boolean foundZeroSum = false;
        while(!foundZeroSum && p1 != null) {
            p2 = p1;
            int sum = 0;
            while(!foundZeroSum && p2 != null) {
                sum += p2.val;
                if(sum == 0) {
                    foundZeroSum = true;
                    if(p0 == null) {
                        newHead = p2.next;
                    } else {
                        p0.next = p2.next;
                    }
                }
                p2 = p2.next;
            }
            p0 = p1;
            p1 = p1.next;
        }
        
        if(foundZeroSum) {
            return removeZeroSumSublists(newHead);
        }
        return newHead;
    }
}