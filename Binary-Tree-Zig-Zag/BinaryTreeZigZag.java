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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        boolean leftToRight = true;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            while(size > 0) {
                TreeNode currentNode = queue.remove();
                list.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                size--;
            }
            
            if(!leftToRight) {
                Collections.reverse(list);
            }
            
            result.add(list);
            
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}