class Solution {
        
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum(nums, target, 4);  
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int k) { 
        
        Arrays.sort(nums);
        
        System.out.println("Sorted array: " + Arrays.toString(nums));
        
        int currIncr = k - 1;
        
        System.out.println("Current increment: " + currIncr);
        
        int[] pointerArr = new int[k];
        for(int i = 0; i < k; i++) {
            pointerArr[i] = i;
        }
        
        System.out.println("Starting pointer array: " + Arrays.toString(pointerArr));
        
        return kSumStep(nums, target, k, currIncr, pointerArr);
    }
    
    private List<List<Integer>> kSumStep(int[] nums, int target, int k, int currIncr, int[] pointerArr) {

        List<Integer> newSolutions = new ArrayList<Integer>();
        
        int sum = 0;
        
        System.out.println("");
        System.out.println("In k Sum Step");
        System.out.println("Current increment " + currIncr);
        System.out.println("Pointer array " + Arrays.toString(pointerArr));
        
        // Iterate along pointers and take the sum
        for(int i = 0; i < pointerArr.length; i++) {
            int currPointer = pointerArr[i];             
            if(currPointer < nums.length) {
                sum += nums[currPointer];
                newSolutions.add(nums[currPointer]);
            // If the last pointer is falling off the edge then we should return
            } else {                 
                System.out.println("Quitting loop, current pointer " + currPointer);
                return new ArrayList<List<Integer>>();
            }
        }
                
        System.out.println("Detected sum as " + sum);
        
        // Move pointer along
        pointerArr[currIncr] = pointerArr[currIncr] + 1;
        
        System.out.println("Moved pointer along, pointer array now " + Arrays.toString(pointerArr));
        
        int newIncr = (currIncr - 1 < 0) ? k - 1 : currIncr - 1;
        
        System.out.println("Change increment, now " + newIncr);
        
        if(sum == target) {
            System.out.println("Found a solution! " + newSolutions);
            
            List<List<Integer>> arrayList = kSumStep(nums, target, k, newIncr, pointerArr);
            arrayList.add(newSolutions);
            return arrayList;
        } else {
            System.out.println("Not a solution " + newSolutions);
            
            List<List<Integer>> arrayList = kSumStep(nums, target, k, newIncr, pointerArr);
            return arrayList;
        }
    }
}