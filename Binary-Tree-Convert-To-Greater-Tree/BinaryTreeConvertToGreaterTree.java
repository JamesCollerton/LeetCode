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
    
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        reverseInOrder(root);
        
        return root;
    }
    
    private void reverseInOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        
        reverseInOrder(node.right);
        int currentVal = node.val;
        sum += node.val;
        node.val = sum;
        reverseInOrder(node.left);
        
    }
}