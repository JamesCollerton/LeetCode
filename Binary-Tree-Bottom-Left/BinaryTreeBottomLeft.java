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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeft = 0;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            int initialSize = size;
            
            while(!queue.isEmpty() && size > 0) {
                TreeNode node = queue.poll();
                if(queue.size() == initialSize - 1) {
                    bottomLeft = node.val;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            
        }
        
        return bottomLeft;
    }
}