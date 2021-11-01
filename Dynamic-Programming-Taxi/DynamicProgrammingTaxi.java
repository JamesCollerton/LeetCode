class Solution {
    
    final int START = 0, END = 1, TIP = 2;
    
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        Map<Integer, List<Ride>> startToRideMap = new HashMap<>();
        
        int maxStart = 0;
        for(int i = 0; i < rides.length; i++) {
            
            Ride ride = new Ride(rides[i][START], rides[i][END], rides[i][TIP]);
            
            if(startToRideMap.containsKey(ride.start)) {
                startToRideMap.get(ride.start).add(ride);
            } else {
                List<Ride> list = new ArrayList<>();
                list.add(ride);
                startToRideMap.put(ride.start, list);
            }
            
            if(ride.start > maxStart) {
                maxStart = ride.start;
            }
        }
        
        int maxProfit = 0;
                
        long[] dp = new long[n + 1];
        for(int i = n - 1; i > 0; i--) {
            if(startToRideMap.containsKey(i)) {
                for(Ride ride: startToRideMap.get(i)) {
                    dp[i] = dp[i] > dp[ride.end] + ride.profit ? dp[i] : dp[ride.end] + ride.profit;
                }
            }
            dp[i] = dp[i] > dp[i + 1] ? dp[i] : dp[i + 1];
        }
        
        return dp[1];
    }
        
    private class Ride {
        
        int start;
        int end;
        int tip;
        int profit;
        
        Ride(int start, int end, int tip) {
            this.start = start;
            this.end = end;
            this.tip = tip;
            this.profit = end - start + tip;
        }
        
    }
}