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
        
        List<TreeNode> nodeList = new ArrayList<>();
        
        recurse(root, nodeList);
        
        for(int i = 0; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            node.left = null;
            if(i + 1 < nodeList.size()) {
                node.right = nodeList.get(i + 1);
            }
        }
    }
    
    private void recurse(TreeNode node, List<TreeNode> nodeList) {
        if(node == null) {
            return;
        }
        
        nodeList.add(node);
        
        recurse(node.left, nodeList);
        recurse(node.right, nodeList);
    }
}