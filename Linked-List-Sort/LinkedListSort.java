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
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
                    
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode nodeSlow = head;
        ListNode nodeFast = head;
        
        while(nodeFast != null && nodeFast.next != null) {
            prev = nodeSlow;
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
        }
        
        prev.next = null;
        
        ListNode leftList = mergeSort(head);
        ListNode rightList = mergeSort(nodeSlow);
        
        return merge(leftList, rightList);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
    
}