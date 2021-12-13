class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++) {
            
            int currentNumber = nums2[i];
            
            while(!stack.isEmpty() && stack.peek() < currentNumber) {
                int lesserNumber = stack.pop();
                map.put(lesserNumber, currentNumber);
            }
            
            stack.push(currentNumber);
            
        }
        
        while(!stack.isEmpty()) {
            int remainingNumber = stack.pop();
            map.put(remainingNumber, -1);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}