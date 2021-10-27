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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        List<TreeNode> headNodesInTree = new ArrayList<>();
        findHeadNodesInTree(head, root, headNodesInTree);
        
        for(TreeNode treeNode: headNodesInTree) {
            if(comparePaths(head, treeNode)) {
                return true;
            }
        }
        
        return false;
    }
    
    private void findHeadNodesInTree(ListNode head, TreeNode node, List<TreeNode> result) {
        if(node == null) {
            return;
        }
        
        if(node.val == head.val) {
            result.add(node);
        }
        
        findHeadNodesInTree(head, node.left, result);
        findHeadNodesInTree(head, node.right, result);
    }
    
    private boolean comparePaths(ListNode listNode, TreeNode treeNode) {
        if(listNode.next == null) {
            return true;
        }
        
        if(treeNode == null) {
            return false;
        }
        
        boolean matches = false;
        
        if(treeNode.left != null && listNode.next.val == treeNode.left.val) {
            matches = comparePaths(listNode.next, treeNode.left);
        }
        
        if(treeNode.right != null && listNode.next.val == treeNode.right.val) {
            matches = matches || comparePaths(listNode.next, treeNode.right);
        }
        
        return matches;
    }  
}