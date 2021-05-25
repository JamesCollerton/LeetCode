class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0 || height.length == 1) {
            return 0;
        }
        
        int i = 0;
        int total = 0;
        
        while(i < height.length) {
            
            int j = i + 1;
            boolean found = false;
            
            // System.out.println("i: " + i);
            // System.out.println("j: " + j);
            
            while(!found && j < height.length) {
                
                // System.out.println("Inside loop j: " + j);
                // System.out.println("Height i: " + height[i]);
                // System.out.println("Height j: " + height[j]);
                
                if(height[i] <= height[j]) {
                    
                    // System.out.println("Detected height i less than height j");
                    
                    int maxDepth = (j - i - 1) * min(height[i], height[j]);
                    
                    // System.out.println("Max depth " + maxDepth);
                    
                    for(int k = i + 1; k < j; k++) {
                        // System.out.println("Subtracting value at k " + k);
                        // System.out.println("Subtracting height " + height[k]);
                        maxDepth -= height[k];
                    }
                    
                    total += maxDepth;
                    i = j;
                    found = true;
                    
                    // System.out.println("Adjusted max depth " + maxDepth);
                    // System.out.println("New total " + total);
                    // System.out.println("New i " + i);
                    
                } else {
                    
                    // System.out.println("Height i too low, incrementing j ");
                    j++;
                } 
            }
            
            if(!found) {
                // System.out.println("Not found a valid greater column");
                i++;
            }
        }
        
        return total;
    }
    
    private int min(int a, int b) {
        return a < b ? a : b;
    }
}