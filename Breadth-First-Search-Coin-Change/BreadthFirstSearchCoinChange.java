class Solution {
    
    // private class RunningTotal {
    //     // Do we need the coin value?
    //     int coinValue;
    //     int runningTotal;
    //     int depth;
    //     RunningTotal(int coinValue, int runningTotal, int depth) {
    //         this.coinValue = coinValue;
    //         this.runningTotal = runningTotal;
    //         this.depth = depth;
    //     }
    //     @Override
    //     public String toString() {
    //         System.out.println("");
    //         System.out.println("Coin value " + coinValue);
    //         System.out.println("Running total " + runningTotal);
    //         System.out.println("Depth " + depth);
    //         return "";
    //     }
    // }
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(coins);
                                
        for(int i = 0; i < coins.length; i++) {
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(coins[i]);
            int depth = 1;
                                    
            while(!queue.isEmpty()) {
                
                int size = queue.size();
                boolean keepGoing = true;
                
                while(size > 0 && keepGoing) {
                
                    int currentTotal = queue.poll();

                    for(int j = 0; j < coins.length && keepGoing; j++) {
                        if(currentTotal > amount) {
                            keepGoing = false;
                        } else if(currentTotal == amount) {
                            min = Math.min(min, depth);
                            keepGoing = false;
                        } else {
                            int newRunningTotal = currentTotal + coins[j];
                            if(newRunningTotal > 0) {
                                queue.offer(newRunningTotal);
                            }
                        }
                    }
                    
                    size--;
                }
                
                depth++;
                
            }
            
        }
        
        return min == Integer.MAX_VALUE ? -1 : min; 
    }
}