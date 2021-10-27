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
    public int[] nextLargerNodes(ListNode head) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode node = head;
        while(node != null) {
            list.add(node);
            node = node.next;
        }
        
        int[] result = new int[list.size()];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < result.size(); ++i) {
            
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            
            stack.push(i);
        }
        
        return result;
        
    }
}