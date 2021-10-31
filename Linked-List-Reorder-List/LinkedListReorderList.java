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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        
        int moveLimit = stack.size() / 2;
        ListNode p1 = head;
        ListNode p2 = stack.pop();
        int counter = 0;
        
        while(counter < moveLimit) {
                                    
            stack.peek().next = null;
            
            ListNode temp = p1.next;
            p1.next = p2;
            p2.next = temp;
                
            p1 = temp;
            p2 = stack.pop();
            counter++;
        }
    }
}