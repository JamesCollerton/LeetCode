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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        List<Integer> list = new ArrayList<>();
        
        ListNode node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        
        return recurse(list);
    }
    
    private TreeNode recurse(List<Integer> list) {
        
        if(list.size() == 0) {
            return null;
        }
        
        int middle = list.size() / 2;
        TreeNode node = new TreeNode(list.get(middle));
        TreeNode leftNode = recurse(list.subList(0, middle));
        TreeNode rightNode = recurse(list.subList(middle + 1, list.size()));
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}