class Solution {
    public int nthUglyNumber(int n) {
        
        // Create a map from ugly numbers to their potential multipliers
        Map<Long, List<Integer>> map = new HashMap<>();
        
        // This is our list of ugly numbers
        List<Long> result = new ArrayList<>();
        
        // The first thing we can do is take 1, our seed, and multiply by
        // 2, 3 or 5
        map.put(1L, new ArrayList<>(Arrays.asList(2, 3, 5)));
        result.add(1L);
                
        // We want n > 1 as we have manually done our first step.
        while(n > 1) {
                        
            // This is the ugly number we need to use to generate
            // the next one. We keep track so we can remove the
            // first multiplier from the list after we use it.
            long uglyNumberGeneratingMin = 0L;
            
            // This is the minimum next one we can generate, this
            // keeps us in order
            long currentNextMinUglyNumber = Long.MAX_VALUE;
            
            // Go through all previous ugly numbers and look for the
            // one that can generate the next min. Adding a small
            // optimisation to stop looking up the list when we have
            // the next number is greater than the current min
            int i = 0;
            long currentUglyNumber = result.get(0);
            List<Integer> toRemove = new ArrayList<>();
            
            while(i < result.size() && currentUglyNumber < currentNextMinUglyNumber) {
                
                currentUglyNumber = result.get(i);
                
                // Check for this number we haven't already used all the 
                // multipliers
                if(!map.get(currentUglyNumber).isEmpty()) {
                    
                    // Get the lowest possible multiplier for this number
                    int lowestMultiplier = map.get(currentUglyNumber).get(0);
                    
                    // Calculate the next ugly number if we multiply this ugly
                    // number by the next multiplier
                    long potentialNextUglyNumber = lowestMultiplier * currentUglyNumber;
                    
                    // We need to check we haven't seen it before because
                    // we can generate same number different ways
                    if(!map.containsKey(potentialNextUglyNumber)) {
                        if(potentialNextUglyNumber < currentNextMinUglyNumber) {
                            // If this ugly number is less than the previously calculated
                            // one we can replace it.
                            currentNextMinUglyNumber = potentialNextUglyNumber;
                            uglyNumberGeneratingMin = currentUglyNumber;
                        }
                    } else {
                        map.get(currentUglyNumber).remove(0);
                    }
                } else {
                    toRemove.add(i);
                }
                                
                i++;
            }
            
            for(int j = 0; j < toRemove.size(); j++) {
                result.remove(j);
            }
            
            // Now we add the next calculated number
            result.add(currentNextMinUglyNumber);
            
            // It can be multiplied by any of 2, 3 or 5
            map.put(currentNextMinUglyNumber, new ArrayList<>(Arrays.asList(2, 3, 5)));
            
            // Now remove the multiplier we used from the
            // value we used to generate the min.
            map.get(uglyNumberGeneratingMin).remove(0);
            
            n--;
        }
        
        return Math.toIntExact(result.get(result.size() - 1));
    }
}