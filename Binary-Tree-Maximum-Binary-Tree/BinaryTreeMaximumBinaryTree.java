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
    
    private class ListItem {
        int value;
        int index;
        ListItem(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
                
        List<ListItem> numberToIndexList = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            numberToIndexList.add(new ListItem(nums[i], i));
        }
        
        List<ListItem> sortedNumberToIndexList = numberToIndexList.stream()
            .sorted((i1, i2) -> i1.value < i2.value ? 1 : -1)
            .collect(Collectors.toList());
        
        return recurse(sortedNumberToIndexList, 0, nums.length - 1);
    }
    
    private TreeNode recurse(List<ListItem> list, int leftIndex, int rightIndex) {
        if(leftIndex > rightIndex) {
            return null;
        }
        
        int i = 0;
        while(!(list.get(i).index >= leftIndex && list.get(i).index <= rightIndex)) {
            i++;
        }
        
        ListItem nextListItem = list.get(i);
        list.remove(i);
        
        TreeNode newNode = new TreeNode(nextListItem.value);
        newNode.left = recurse(list, leftIndex, nextListItem.index - 1);
        newNode.right = recurse(list, nextListItem.index + 1, rightIndex);
        
        return newNode;
    }
}