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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentLevel = 0;
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            result.add(new ArrayList<Integer>());
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                
                result.get(currentLevel).add(node.val);
                
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left != null) {
                    queue.add(left);
                }
                if(right != null) {
                    queue.add(right);
                }
                size--;
            }
            currentLevel++;
            
        }
        
        return result;
    }
}