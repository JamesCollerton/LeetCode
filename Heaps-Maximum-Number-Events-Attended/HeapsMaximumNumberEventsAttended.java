class Solution {
    
    public int maxEvents(int[][] events) {
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        for(int[] event: events) {
            queue.offer(event);
        }
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            
            count++;
            
            int[] event = queue.poll();
            
            int start = event[0];
            
            while(!queue.isEmpty() && queue.peek()[0] == start) {
                
                int[] clashingEvent = queue.poll();
                if(clashingEvent[0] != clashingEvent[1]) {
                    int[] newEvent = new int[]{start + 1, clashingEvent[1]};
                    queue.offer(newEvent);
                }
                
            }
            
        }
   
        return count;
        
    }
}