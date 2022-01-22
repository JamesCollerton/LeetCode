class Solution {
        
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
                    
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(amount);
        int level = 1;
        
        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size > 0) {

                int remainder = queue.poll();
                
                for(int i = 0; i < coins.length; i++) {
                    int newRemainder = remainder - coins[i];
                    if(newRemainder == 0) {
                        return level;
                    }
                    if(newRemainder > 0 && !visited[newRemainder]) {
                        visited[newRemainder] = true;
                        queue.offer(newRemainder);
                    }

                }

                size--;
            }
            
            level++;

        }
        
        return -1;
    }
}