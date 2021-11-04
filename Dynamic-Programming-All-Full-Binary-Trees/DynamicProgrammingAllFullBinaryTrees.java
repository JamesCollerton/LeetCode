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
    
    private List<TreeNode> result = new ArrayList<>();
    private int remaining;
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        TreeNode root = new TreeNode(0);
        
        remaining = n - 1;
        
        recurse(root, root);
        
        return result;
    }
    
    private void recurse(TreeNode root, TreeNode currentNode) {
        
        currentNode.left = new TreeNode(0);
        currentNode.right = new TreeNode(0);
        
        remaining -= 2;
        
        if(remaining >= 2) {            
            recurse(root, currentNode.left);
            recurse(root, currentNode.right);
        } else {
            result.add(clone(root));
        }
        
        currentNode.left = null;
        currentNode.right = null;
        
        remaining += 2;
    }
    
    private TreeNode clone(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(0);
        newNode.left = clone(node.left);
        newNode.right = clone(node.right);
        return newNode;
    }
}