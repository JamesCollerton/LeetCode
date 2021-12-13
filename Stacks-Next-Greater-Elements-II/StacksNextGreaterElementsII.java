class Solution {
    
    private class StackItem {
        int value;
        int index;
        StackItem(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public int[] nextGreaterElements(int[] nums) {
        
        int[] result = new int[nums.length];
        
        Stack<StackItem> stack = new Stack<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            int currentNumber = nums[i];
            
            while(!stack.isEmpty() && stack.peek().value < currentNumber) {
                StackItem stackItem = stack.pop();
                result[stackItem.index] = currentNumber;
            }
            
            stack.push(new StackItem(currentNumber, i));
            
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            int currentNumber = nums[i];
            
            while(!stack.isEmpty() && stack.peek().value < currentNumber) {
                StackItem stackItem = stack.pop();
                result[stackItem.index] = currentNumber;
            }
            
        }
        
        while(!stack.isEmpty()) {
            StackItem stackItem = stack.pop();
            result[stackItem.index] = -1;
        }
        
        
        return result;
    }
}