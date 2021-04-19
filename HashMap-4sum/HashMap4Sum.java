class Solution {
        
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);  
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) { 
        List<List<Integer>> res = new ArrayList<>();
        
        if(start == nums.length) {
            System.out.println("We're at the end of the array, stop.");
            return res;
        } else if(nums[start] * k > target) {
            System.out.println("The array is sorted, we can't get equal to target");
            return res;
        } else if(target > nums[nums.length - 1] * k) {
            System.out.println("The target is too big, we can't do it");   
        }
        
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

        if(currIncr < 0) {
            return new ArrayList<List<Integer>>();
        }
        
        List<Integer> newSolutions = new ArrayList<Integer>();
        
        int sum = 0;
        
        System.out.println("");
        System.out.println("In k Sum Step");
        System.out.println("Current increment " + currIncr);
        System.out.println("Pointer array " + Arrays.toString(pointerArr));
        
        // Iterate along pointers and take the sum
        for(int i = 0; i < pointerArr.length; i++) {
            int currPointer = pointerArr[i];             
            sum += nums[currPointer];
            newSolutions.add(nums[currPointer]);
        }
                
        System.out.println("Detected sum as " + sum);                
        System.out.println("Pointer array current increment is " + pointerArr[currIncr]);
        
        if(pointerArr[currIncr] == nums.length - 1) {
            System.out.println("Detected we're at the end of the array");
            currIncr -= 1;
            
        } else if((currIncr < pointerArr.length - 1) && pointerArr[currIncr] + 1 == pointerArr[currIncr + 1]) {
            System.out.println("Detected we're going to collide with the next pointer");
            currIncr -= 1;
        } else {
            System.out.println("Moving the pointer along");
            pointerArr[currIncr] = pointerArr[currIncr] + 1;
        }
        
        System.out.println("Moved pointer along, pointer array now " + Arrays.toString(pointerArr));        
        System.out.println("Current increment now " + currIncr);
        
        if(sum == target) {
            System.out.println("Found a solution! " + newSolutions);
            
            List<List<Integer>> arrayList = kSumStep(nums, target, k, currIncr, pointerArr);
            arrayList.add(newSolutions);
            return arrayList;
        } else {
            System.out.println("Not a solution " + newSolutions);
            
            List<List<Integer>> arrayList = kSumStep(nums, target, k, currIncr, pointerArr);
            return arrayList;
        }
    }
}