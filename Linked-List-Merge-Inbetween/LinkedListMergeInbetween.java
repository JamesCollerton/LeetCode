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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode node = list1;
        ListNode pointToList2 = null;
        ListNode pointToFromList2 = null;
        
        int counter = 0;
        
        while(node != null) {
            if(counter == a - 1) {
                pointToList2 = node;
            }
            if(counter == b + 1) {
                pointToFromList2 = node;
            }
            counter++;
            node = node.next;
        }
        
        ListNode endOfList2 = list2;
        
        while(endOfList2.next != null) {
            endOfList2 = endOfList2.next;
        }
        
        pointToList2.next = list2;
        endOfList2.next = pointToFromList2;
        
        return list1;
    }
}