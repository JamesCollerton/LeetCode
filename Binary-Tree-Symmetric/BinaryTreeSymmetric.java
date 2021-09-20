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
    
    private final String SPLIT_CHAR = "/";
    
    public boolean isSymmetric(TreeNode root) {
        String[] split = generateHash(root, 0).split(SPLIT_CHAR);
        for(int i = 0; i < split.length; i++) {
            if(!split[i].equals(split[split.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
    
    private String generateHash(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            return "" + node.val + "x" + depth;
        } else if(node.left == null) {
            return node.val + "x" + depth + SPLIT_CHAR + 
                    generateHash(node.right, depth + 1);
        } else if(node.right == null) {
            return generateHash(node.left, depth + 1) + 
                    SPLIT_CHAR + node.val + "x" + depth;
        } else {
            return generateHash(node.left, depth + 1) + SPLIT_CHAR + 
                    node.val + "x" + depth + 
                    SPLIT_CHAR + generateHash(node.right, depth + 1);
        }
    }
}