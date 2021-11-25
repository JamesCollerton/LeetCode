class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<>();
        
        int leftPointer = 0;
        int rightPointer = 1;
        
        while(leftPointer < nums.length - 1) {
            
            rightPointer = leftPointer + 1;
            
            List<List<Integer>> listsToAddTo = new ArrayList<>();
            List<Integer> initialList = new ArrayList<>();
            initialList.add(nums[leftPointer]);
            listsToAddTo.add(initialList);
            
            while(rightPointer < nums.length) {
                
                int listsToAddToSize = listsToAddTo.size();
                
                for(int i = 0; i < listsToAddToSize; i++) {
                    
                    List<Integer> currentList = listsToAddTo.get(i);
                    
                    if(currentList.get(currentList.size() - 1) <= nums[rightPointer]) {
                        
                        List<Integer> listCopy = new ArrayList<>(currentList);
                        listsToAddTo.add(listCopy);
                        currentList.add(nums[rightPointer]);   
                        result.add(new ArrayList<>(currentList));
                        
                    }
                }
                rightPointer++;
            }
            
            leftPointer++;
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}