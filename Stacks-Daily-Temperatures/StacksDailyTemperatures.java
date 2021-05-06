class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        // Initialised to all zeros
        int[] result = new int[T.length];
        
        // Create a new stack for putting temperatures on
        Stack<Integer> stack = new Stack<>();
        
        // Loop through all temperatures
        for(int i = 0; i < T.length; i++) {
            
            // Get the current temperature in the list
            int currentTemp = T[i];
            
            // If the stack isn't empty then we want to
            // look at it. If it is empty then we only want
            // to add this item to the stack, as all other
            // entries have found a higher temperature
            if(!stack.isEmpty()) {
                
                boolean go = true;
                
                // Get each index off the stack and look up
                // the temperature at that time. If it is less
                // than the current temperature we detect a
                // temperature increase. If it is not then we
                // know all remaining items on the stack will be
                // strictly increasing, and so we can stop. They
                // can't decrease or they'd have been popped before
                while(!stack.isEmpty() && go) {
                    
                    int lastTempIndex = stack.peek();
                    
                    if(T[lastTempIndex] < currentTemp) {
                        
                        int tempIndex = stack.pop();
                        result[tempIndex] = i - tempIndex;
                        
                    } else {
                        go = false;
                    }   
                }
            }
            
            stack.push(i);
        }
        
        return result;
    }
}