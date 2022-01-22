class Solution {
        
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(coins);
        
        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }
                                        
        for(int i = 0; i < coins.length; i++) {
            
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> seenTotals = new HashSet<>();
            queue.offer(coins[i]);
            seenTotals.add(coins[i]);
            int depth = 1;
                                    
            while(!queue.isEmpty()) {
                
                int size = queue.size();
                boolean keepGoing = true;
                // int levelMinSize = Integer.MAX_VALUE;
                
                while(size > 0 && !queue.isEmpty() && keepGoing) {
                
                    int currentTotal = queue.poll();
                    // System.out.println("Current total: " + currentTotal);

                    for(int j = 0; j < coins.length && keepGoing; j++) {
                        if(currentTotal == amount) {
                            min = Math.min(min, depth);
                            keepGoing = false;
                        } else {
                            int newRunningTotal = currentTotal + coins[j];
                            if(newRunningTotal > 0 && !seenTotals.contains(newRunningTotal) && newRunningTotal <= amount) {
                                // levelMinSize = Math.min(levelMinSize, newRunningTotal);
                                seenTotals.add(newRunningTotal);
                                queue.offer(newRunningTotal);
                            }
                        }
                    }
                    
                    // System.out.println(levelMinSize);
                    
                    size--;
                }
                
                // System.out.println("Increasing depth");
                depth++;
            }
            
        }
        
        return min == Integer.MAX_VALUE ? -1 : min; 
    }
}