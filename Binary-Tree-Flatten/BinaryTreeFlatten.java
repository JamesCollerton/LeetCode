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
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        flatten(root, null);
    }
    
    private TreeNode flatten(TreeNode currentNode, TreeNode previousNode) {
        
        if(previousNode != null) {
            previousNode.right = currentNode;
        }
        
        TreeNode tempLeft = currentNode.left;
        TreeNode tempRight = currentNode.right;
        currentNode.left = null;
        currentNode.right = null;
        
        if(tempLeft != null) {
            currentNode = flatten(tempLeft, currentNode);
        }
        if(tempRight != null) {
            currentNode = flatten(tempRight, currentNode);
        }
        
        return currentNode;
    }
    
}