class Solution {
    
    private class Interval {
        
        int start;
        int end;
        int originalPosition;
        
        Interval(int start, int end, int originalPosition) {
            this.start = start;
            this.end = end;
            this.originalPosition = originalPosition;
        }
    }
    
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
        
        List<Interval> intervalList = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            intervalList.add(new Interval(interval[0], interval[1], i));
        }
        
        Collections.sort(intervalList, (a, b) -> a.start - b.start);
        
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            
            Interval currentInterval = intervalList.get(i);
            
            int j = i + 1;
            int index = -1;
            
            while(j < n && index == -1) {
                
                Interval rightInterval = intervalList.get(j);
                
                if(rightInterval.start >= currentInterval.end) {
                    index = rightInterval.originalPosition;
                }
                
                j++;
            }
            
            result[currentInterval.originalPosition] = index;
        }
        
        return result;
    }
}