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
    
    private int[] inorder;
    private int[] postorder;
    private HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        this.inorder = inorder;
        this.postorder = postorder;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return recurse(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode recurse(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if(inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int value = postorder[postorderEnd];
        int inorderIndex = map.get(value);
        TreeNode node = new TreeNode(value);
        node.left = recurse(inorderStart, inorderIndex-1, postorderStart, postorderStart+inorderIndex-inorderStart-1);
        node.right = recurse(inorderIndex+1, inorderEnd, postorderStart+inorderIndex-inorderStart, postorderEnd-1);
        return node;
    }
}