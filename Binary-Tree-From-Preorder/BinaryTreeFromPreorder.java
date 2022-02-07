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
    
    int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int max) {
        TreeNode node = new TreeNode(preorder[index++]);
        if(index < preorder.length && preorder[index] < node.val) {
            node.left = helper(preorder, node.val);
        }
        if(index < preorder.length && preorder[index] > node.val && preorder[index] < max) {
            node.right = helper(preorder, max);
        }
        return node;
    }
    
}