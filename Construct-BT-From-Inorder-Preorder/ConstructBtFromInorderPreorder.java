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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int preorderIndex = 1;
        
        insertNode(root, null, preorder, inorder, preorderIndex);
        
        return root;
    }
    
    private void insertNode(TreeNode node, TreeNode parent, int[] preorder, int[] inorder, int preorderIndex) {
        
        if(preorderIndex >= preorder.length) {
            return;
        }
        
        int valToInsert = preorder[preorderIndex];
        int currentNodeVal = node.val;
        int parentNodeVal = parent == null ? Integer.MIN_VALUE : parent.val;
        
        boolean beforeCurrentNode = true;
        boolean beforeParentNode = true;
        
        boolean found = false;
        int inorderIndex = 0;
        
        while(!found) {
            if(inorder[inorderIndex] == valToInsert) {
                found = true;
            } else if(inorder[inorderIndex] == currentNodeVal) {
                beforeCurrentNode = false; 
            } else if(inorder[inorderIndex] == parentNodeVal) {
                beforeParentNode = false;
            }
            inorderIndex++;
        }
        
        if(beforeCurrentNode) {
            TreeNode newNode = new TreeNode(preorder[preorderIndex]);
            node.left = newNode;
            insertNode(newNode, node, preorder, inorder, preorderIndex + 1);
        } else if(beforeParentNode) {
            TreeNode newNode = new TreeNode(preorder[preorderIndex]);
            node.right = newNode;
            insertNode(newNode, node, preorder, inorder, preorderIndex + 1);
        } else {
            insertNode(parent, null, preorder, inorder, preorderIndex);
        }
    }
}