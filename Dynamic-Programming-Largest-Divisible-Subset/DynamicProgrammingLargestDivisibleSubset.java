class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<List<Integer>> divisibleSubsets = new ArrayList<>();
         
        for(int i = 0; i < nums.length; i++) {
            
            int currentNum = nums[i];
            
            int divisibleSubsetsSize = divisibleSubsets.size();
            for(int j = 0; j < divisibleSubsetsSize; j++) {
                                
                List<Integer> list = divisibleSubsets.get(j);
                
                boolean success = true;
                int k = 0;
                
                while(success && k < list.size()) {
                    
                    int next = list.get(k);
                    
                    if(!(next % currentNum == 0 || currentNum % next == 0)) {
                        success = false;
                    }
                    
                    k++;
                }
                
                if(success) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(currentNum);
                    divisibleSubsets.add(newList);
                }
                
            }
            
            List<Integer> newList = new ArrayList<>();
            newList.add(nums[i]);
            divisibleSubsets.add(newList);
        }
        
        return divisibleSubsets.stream().sorted((l1, l2) -> l2.size() - l1.size()).findFirst().get();
    }
}