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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] result = new ListNode[k];
        
        if(head == null) {
            return result;
        }
        
        int length = 0;
        ListNode node = head;
        while(node != null) {
            length++;
            node = node.next;
        }
        
        int partLength = length / k == 0 ? 1 : length / k;
        int remainder = length - (partLength * k);
        int index = 0;
        int counter = partLength;
        
        // Could we have problems here?
        node = head;
        result[index] = node;
        index++;
        counter--;
                
        ListNode previous = node;
        node = node.next;
        
        while(node != null) {
            if((remainder > 0 && counter + 1 == 0) || (remainder <= 0 && counter == 0)) {
                result[index] = node;
                remainder--;
                index++;
                counter = partLength - 1;
                
                previous.next = null;
                
            } else {
                
                counter--;
                
            }
            
            previous = node;
            node = node.next;
        }
                
        return result;
    }
}