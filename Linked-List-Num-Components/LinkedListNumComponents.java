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
        int groups = 0;
        boolean inGroup = false;
        
        while(node != null) {
            if(set.contains(node.val) && !inGroup) {
                inGroup = true;
                groups++;
            } else if(!set.contains(node.val) && inGroup) {
                inGroup = false;
            }
            node = node.next;
        }
        
        return groups;
    }
}