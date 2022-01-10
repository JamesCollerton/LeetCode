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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return maxDepth(root, 0);
    }
    
    private int maxDepth(TreeNode node, int result) {
        if(node == null) {
            return result;
        }
        return Math.max(maxDepth(node.left, result + 1), maxDepth(node.right, result + 1));
    }
}