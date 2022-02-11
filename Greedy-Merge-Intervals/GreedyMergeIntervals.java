class Solution {
    
    class Interval {
        int start;
        int end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        
        List<Interval> intervalList = new ArrayList<>();
        
        for(int[] interval: intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        
        Collections.sort(intervalList, (a, b) -> a.start - b.start);
        
        int start = intervalList.get(0).start;
        int end = intervalList.get(0).end;
        
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0; i < intervalList.size(); i++) {
            Interval interval = intervalList.get(i);
            if(interval.start > end) {
                result.add(new int[]{start, end});
                start = interval.start;
                end = interval.end;
            } else if(interval.end > end) {
                end = interval.end;
            }
        }
        
        result.add(new int[] {start, end});
        
        int[][] resultArr = new int[result.size()][2];
        
        for(int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        
        return resultArr;
    }
    
}