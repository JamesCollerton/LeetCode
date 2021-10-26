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
    
    private int counter;
    
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        
        recurse(root, list);
        
        return list.get(k - 1);
    }
    
    private void recurse(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        
        recurse(node.left, list);
        list.add(node.val);
        recurse(node.right, list);
    }
}