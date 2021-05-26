class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        
        for(int i = 0; i < gas.length; i++) {
            int currentStop = i;
            int tank = 0;
            boolean done = false;
            while(!done) {
                tank += gas[currentStop];
                int costForNextStop = cost[currentStop];
                if(costForNextStop > tank) {
                    done = true;
                } else {
                    int nextStop = (currentStop + 1 >= gas.length) ? 0 : currentStop + 1;
                    if(nextStop == i) {
                        result = i;
                        done = true;
                    } else {
                        tank -= costForNextStop;
                        currentStop = nextStop;
                    }
                }
            }
        }
        
        return result;
    }
}