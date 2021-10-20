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
    public List<TreeNode> generateTrees(int n) {
        return recurse(1, n);
    }
    
    private List<TreeNode> recurse(int low, int high) {
        if(low == high) {
            List<TreeNode> result = new ArrayList<>();
            result.add(new TreeNode(low));
            return result;
        } if(low > high) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }
        
        List<TreeNode> list = new ArrayList<>();
        
        for(int i = low; i <= high; i++) {
            List<TreeNode> leftList = recurse(low, i - 1);
            List<TreeNode> rightList = recurse(i + 1, high);
            for(int j = 0; j < leftList.size(); j++) {
                for(int k = 0; k < rightList.size(); k++) {
                    TreeNode node = new TreeNode(i, leftList.get(j), rightList.get(k));
                    list.add(node);
                }
            }
        }
        
        return list;
    }
}