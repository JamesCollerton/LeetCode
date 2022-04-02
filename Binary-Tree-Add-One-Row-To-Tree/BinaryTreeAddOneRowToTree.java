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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int currentDepth = 1;
        
        while(!queue.isEmpty()) {
            
            if(currentDepth == depth - 1) {
                
                while(!queue.isEmpty()) {
                    
                    TreeNode node = queue.poll();
                    
                    TreeNode leftNode = new TreeNode(val);
                    TreeNode rightNode = new TreeNode(val);
                    
                    leftNode.left = node.left;
                    rightNode.right = node.right;
                    
                    node.left = leftNode;
                    node.right = rightNode;
                    
                }
                
            } else {
                
                int size = queue.size();
                
                while(size > 0 && !queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                
                currentDepth++;
                
            }
            
        }
        
        return root;
    }
}