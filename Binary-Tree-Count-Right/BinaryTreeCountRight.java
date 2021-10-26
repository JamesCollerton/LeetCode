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
    public int countNodes(TreeNode root) {
        // Find the leftmost depth
        int leftDepth = countLeft(root);
        
        // Find the rightmost depth
        int rightDepth = countRight(root);
        
        // If they are equal we can reverse engineer
        // the number of nodes as depth = log_2(n + 1)
        // otherwise add this node and then the sum on 
        // the left and right
        if(leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int countLeft(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
    
    private int countRight(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }

}