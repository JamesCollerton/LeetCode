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
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        List<String> result = new ArrayList<>();
        recurse(root, "", result);
        
        int sum = 0;
        for(int i = 0; i < result.size(); i++) {
            sum += Integer.parseInt(result.get(i));
        }
        return sum;
    }
    
    private void recurse(TreeNode node, String number, List<String> result) {        
        String newNumber = number + node.val;
        
        if(node.left == null && node.right == null) {
            result.add(newNumber);
            return;
        }
        
        if(node.left != null) {
            recurse(node.left, newNumber, result);
        }
        if(node.right != null) {
            recurse(node.right, newNumber, result);
        }
    }
}