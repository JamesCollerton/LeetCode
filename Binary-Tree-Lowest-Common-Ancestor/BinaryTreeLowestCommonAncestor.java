/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode p;
    TreeNode q;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return recurse(root);
    }
    
    private TreeNode recurse(TreeNode node) {
        if(node == null) {
            return null;
        }
        if(node == p || node == q) {
            return node;
        }
        
        TreeNode left = recurse(node.left);
        TreeNode right = recurse(node.right);
        
        if(left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}