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
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int preorder[], int start, int end) {
        if(start > end) {
            return null;
        }
        
        int val = preorder[preorderIndex];
        preorderIndex++;
        TreeNode node = new TreeNode(val);
        
        node.left = arrayToTree(preorder, start, map.get(val) - 1);
        node.right = arrayToTree(preorder, map.get(val) + 1, end);
        return node;
    }
}