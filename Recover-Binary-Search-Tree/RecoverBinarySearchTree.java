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
    
    private TreeNode nodeA;
    private TreeNode nodeB;
    
    public void recoverTree(TreeNode root) {
        checkNode(root, null, null);
    }
    
    private void checkNode(TreeNode node, TreeNode lessThanNode, TreeNode moreThanNode) {
        
        if(lessThanNode != null && node.val >= lessThanNode.val) {
            int val = lessThanNode.val;
            lessThanNode.val = node.val;
            node.val = val;
            return;
        }
        
        if(moreThanNode != null && node.val <= moreThanNode.val) {
            int val = moreThanNode.val;
            moreThanNode.val = node.val;
            node.val = val;
            return;
        }
        
        TreeNode newLessThanNode = lessThanNode == null ? node : minNode(node, lessThanNode);
        TreeNode newMoreThanNode = moreThanNode == null ? node : maxNode(node, moreThanNode);
        
        if(node.left != null) {
            checkNode(node.left, newLessThanNode, moreThanNode);
        }
        if(node.right != null) {
            checkNode(node.right, lessThanNode, newMoreThanNode);
        }
    }
    
    private TreeNode minNode(TreeNode a, TreeNode b) {
        return a.val < b.val ? a : b;
    }
    
    private TreeNode maxNode(TreeNode a, TreeNode b) {
        return a.val > b.val ? a : b;
    }
}