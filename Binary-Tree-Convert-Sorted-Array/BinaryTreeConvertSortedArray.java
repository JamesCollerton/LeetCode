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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }
    
    private TreeNode recurse(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        
        TreeNode newNode = new TreeNode(nums[mid]);
            
        int newLeft = mid + 1;
        int newRight = mid - 1;
        
        newNode.left = recurse(nums, left, newRight);
        newNode.right = recurse(nums, newLeft, right);
        
        return newNode;
    }
}