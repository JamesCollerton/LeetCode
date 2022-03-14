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
    public int numComponents(ListNode head, int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums) {
            set.add(num);
        }
        
        ListNode node = head;
        int max = 0;
        int runningCount = 0;
        
        while(node != null) {
            if(set.contains(node.val)) {
                runningCount++;
            } else {
                runningCount = 0;
            }
            max = Math.max(max, runningCount);
            node = node.next;
        }
        
        return max;
    }
}