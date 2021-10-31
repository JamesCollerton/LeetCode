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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        
        ListNode node = head;
        int position = 1;
        
        while(position < left - 1) {
            node = node.next;
            position++;
        }
        
        ListNode beforeList = left == 1 ? null : node;
        
        if(beforeList != null) {
            node = node.next;
            position++;
        }
        
        ListNode endOfList = node;
        
        ListNode previous = null;
        ListNode temp = null;
        
        while(position <= right) {
            temp = node.next;
            node.next = previous;
            previous = node;
            node = temp;
            position++;
        }
        
        ListNode startOfList = previous;        
        ListNode afterList = temp;
        
        if(beforeList != null) {
            beforeList.next = startOfList;
        }
        if(afterList != null) {
            endOfList.next = afterList;
        }
        
        if(beforeList == null) {
            return startOfList;
        } else {
            return head;
        }
    }
}