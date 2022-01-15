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
        
        List<ListNode> list = new ArrayList<>();
        
        ListNode node = head;
        
        while(node != null) {
            list.add(node);
            node = node.next;
        }
            
        quickSort(list);
        
        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        
        return list.get(0);
    }
    
    private void quickSort(List<ListNode> list) {
        quickSort(list, 0, list.size() - 1);
    }
    
    private void quickSort(List<ListNode> list, int start, int finish) {
        
        if(start < finish) {
            
            int partitionIndex = partition(list, start, finish);
            
            quickSort(list, start, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, finish);
        }
        
    }
    
    private int partition(List<ListNode> list, int start, int finish) {
        
        int pivot = list.get(finish).val;
        int i = start - 1;
        
        for(int j = start; j < finish; j++) {
            
            if(list.get(j).val < pivot) {
                
                i++;

                ListNode temp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, temp);
                
            }
            
        }
        
        ListNode temp = list.get(i + 1);
        list.set(i + 1, list.get(finish));
        list.set(finish, temp);

        return i + 1;
        
    }
}