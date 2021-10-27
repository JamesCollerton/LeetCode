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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode node = head;
        
        int n = 0;
        while(node != null) {
            n++;
            node = node.next;
        }
        
        node = head;
        
        ListNode firstNode = null;
        ListNode secondNode = null;
        
        int position = 0;
        while(node != null) {
            position++;
            if(position == k) {
                firstNode = node;
            }
            if(position == n - k + 1) {
                secondNode = node;
            }
            node = node.next;
        }
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        
        return head;
    }
}