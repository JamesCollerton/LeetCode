class Solution {
    
    class Interval implements Comparable<Interval> {
        int start;
        int end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Interval that) {
            return this.end - that.end;
        }
    }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        List<Interval> intervalList = new LinkedList<>();
        
        for(int[] intervalArr: intervals) {
            intervalList.add(new Interval(intervalArr[0], intervalArr[1]));
        }
                             
        Collections.sort(intervalList);
                             
        int end = Integer.MIN_VALUE;
                             
        int count = 0;
        
        for(Interval interval: intervalList) {
            if(interval.start >= end) {
                count++;
                end = interval.end;
            }
        }
        
        return intervals.length - count;
    }
}