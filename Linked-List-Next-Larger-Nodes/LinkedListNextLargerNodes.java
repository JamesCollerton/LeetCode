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
        
        ListNode p1 = head, p2 = head;
        int[] result = new int[10001];
        int index = 0;
        
        while(p1 != null) {
            boolean found = false;
            p2 = p1;
            
            while(!found && p2 != null) {
                if(p2.val > p1.val) {
                    found = true;
                    result[index] = p2.val;
                }
                p2 = p2.next;
            }
            
            if(!found) {
                result[index] = 0;
            }
            
            index++;
            p1 = p1.next;
        }
                
        return Arrays.copyOfRange(result, 0, index);
    }
}