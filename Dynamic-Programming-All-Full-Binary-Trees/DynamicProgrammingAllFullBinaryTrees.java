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
        
    public List<TreeNode> allPossibleFBT(int n) {
        
        List<TreeNode> result = new ArrayList<>();
        
        if(n == 1) {
            result.add(new TreeNode(0));
        
        // We need the odd number so we can have a node and
        // a left and right one
        } else if(n % 2 != 0) {
            
            for(int i = 2; i <= n; i += 2) {
                List<TreeNode> leftNodes = allPossibleFBT(i - 1);
                List<TreeNode> rightNodes = allPossibleFBT(n - i);
                
                for(TreeNode left : leftNodes) {
                    for(TreeNode right : rightNodes) {
                        TreeNode node = new TreeNode(0);
                        node.left = clone(left);
                        node.right = clone(right);
                        result.add(node);
                    }   
                }
            }    
        }
            
        return result;
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