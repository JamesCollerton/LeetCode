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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            recurse(root, targetSum, new ArrayList<Integer>(), result);
        }
        return result;
    }
    
    private void recurse(TreeNode node, int targetSum, List<Integer> nodeValues, List<List<Integer>> result) {
                
        List<Integer> newList = new ArrayList<>(nodeValues);
        newList.add(node.val);
        
        if(node.left == null && node.right == null) {
            int sum = newList.stream().reduce((x, y) -> x + y).orElse(-1001);
            if(sum == targetSum) {
                result.add(newList);
            }
            return;
        }
        
        if(node.left != null) {
            recurse(node.left, targetSum, newList, result);
        }
        
        if(node.right != null) {
            recurse(node.right, targetSum, newList, result);
        }
    }
}