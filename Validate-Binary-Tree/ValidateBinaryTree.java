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
    public boolean isValidBST(TreeNode root) {
        
        Integer lessThan = null;
        Integer moreThan = null;
        
        return checkNode(root, lessThan, moreThan);
        
    }
    
    private boolean checkNode(TreeNode node, Integer lessThan, Integer moreThan) {
        
        if(lessThan != null && node.val >= lessThan) {
            return false;
        }
        
        if(moreThan != null && node.val <= moreThan) {
            return false;
        }
        
        int newLessThan = lessThan == null ? node.val : min(node.val, lessThan);
        int newMoreThan = moreThan == null ? node.val : max(node.val, moreThan);
        
        boolean isBst = true;
        if(node.left != null) {
            isBst = isBst && checkNode(node.left, newLessThan, moreThan);
        }
        if(node.right != null && isBst) {
            isBst = isBst && checkNode(node.right, lessThan, newMoreThan);
        }
        
        return isBst;
    }
    
    private int min(int a, int b) {
        return a < b ? a : b;
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
}