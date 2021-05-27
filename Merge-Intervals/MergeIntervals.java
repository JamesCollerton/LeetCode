class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>(Arrays.asList(intervals));
        list.sort((intervalA, intervalB) -> Integer.compare(intervalA[0], intervalB[0]));
        int currentIndex = 0;
        
        while(currentIndex < (list.size() - 1)) {
            
            int nextIndex = currentIndex + 1;
            
            int[] currentInterval = list.get(currentIndex);
            int[] nextInterval = list.get(nextIndex);
            
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            
            if(currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = max(currentInterval[1], nextInterval[1]);
                list.remove(nextIndex);
            } else {
                currentIndex++;
            }
        }
        
        return list.toArray(new int[0][]);
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
}