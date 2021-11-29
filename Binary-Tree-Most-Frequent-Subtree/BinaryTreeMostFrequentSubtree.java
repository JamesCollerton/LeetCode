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
    
    // Can calculate the result as you go!
    
    private Map<Integer, Integer> sumToFrequencyMap = new HashMap<>();
    
    public int[] findFrequentTreeSum(TreeNode root) {
        recurse(root);
        
        Map<Integer, List<Integer>> frequencyToSumMap = new HashMap<>();
        
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : sumToFrequencyMap.entrySet()) {
            int sum = entry.getKey();
            int frequency = entry.getValue();
            
            maxFrequency = Math.max(maxFrequency, frequency);
            
            if(frequencyToSumMap.containsKey(frequency)) {
                frequencyToSumMap.get(frequency).add(sum);
            } else {
                List<Integer> newSumList = new ArrayList<>();
                newSumList.add(sum);
                frequencyToSumMap.put(frequency, newSumList);
            }
        }
        
        int[] result = new int[frequencyToSumMap.get(maxFrequency).size()];
        
        for(int i = 0; i < frequencyToSumMap.get(maxFrequency).size(); i++) {
            result[i] = frequencyToSumMap.get(maxFrequency).get(i);
        }
        
        return result;
    }
    
    private int recurse(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int leftCount = recurse(node.left);
        int rightCount = recurse(node.right);
        
        int nodeCount = leftCount + node.val + rightCount;
        
        if(sumToFrequencyMap.containsKey(nodeCount)) {
            sumToFrequencyMap.put(nodeCount, sumToFrequencyMap.get(nodeCount) + 1);
        } else {
            sumToFrequencyMap.put(nodeCount, 1);
        }
        
        return nodeCount;
    }
    
}