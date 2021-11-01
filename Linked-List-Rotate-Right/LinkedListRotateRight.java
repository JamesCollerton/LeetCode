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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        
        int rotation = k % stack.size();
        
        ListNode newHead = head;
        
        while(rotation > 0) {
            ListNode popped = stack.pop();
            popped.next = newHead;
            newHead = popped;
            stack.peek().next = null;
            rotation--;
        }
        
        return newHead;
    }
}