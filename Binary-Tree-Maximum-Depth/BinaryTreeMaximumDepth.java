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
        return(recurse(root));
    }
    
    private int recurse(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        } else if(node.left == null) {
            return 1 + recurse(node.right);
        } else if(node.right == null) {
            return 1 + recurse(node.left);
        } else {
            int leftVal = recurse(node.left);
            int rightVal = recurse(node.right);
            int max = leftVal > rightVal ? leftVal : rightVal; 
            return 1 + max;
        }
    }
}