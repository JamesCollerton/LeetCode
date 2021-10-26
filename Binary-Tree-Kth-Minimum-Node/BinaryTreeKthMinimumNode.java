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
    
    private int counter;
    private int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        
        counter = k;
        
        recurse(root);
        
        return result;
    }
    
    private void recurse(TreeNode node) {
        
        if(node == null) {
            return;
        }
        
        if(result == -1) {
            recurse(node.left);
        }
        
        counter--;
        if(counter == 0) {
            result = node.val;
        }
        
        if(result == -1) {
            recurse(node.right);
        }
        
    }
}