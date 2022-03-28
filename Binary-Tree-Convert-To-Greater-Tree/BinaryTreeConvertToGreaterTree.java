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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        convert(root, 0);
        
        return root;
    }
    
    private int convert(TreeNode node, int aboveSum) {
        if(node == null) {
            return aboveSum;
        }
        
        int rightSum = node.right == null ? 0 : convert(node.right, aboveSum);
        
        int oldNodeVal = node.val;
        int newValue = aboveSum + oldNodeVal + rightSum;
        node.val = newValue;
        
        int leftSum = node.left == null ? 0 : convert(node.left, newValue);
        
        return rightSum + oldNodeVal + leftSum;
    }
}