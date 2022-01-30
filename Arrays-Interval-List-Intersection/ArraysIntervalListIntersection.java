class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i = 0, j = 0;
        List<int[]> resultList = new ArrayList<>();
        
        while(i < firstList.length && j < secondList.length) {
            
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];
            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];
            
            int maxStart = Math.max(firstStart, secondStart);
            int minEnd = Math.min(firstEnd, secondEnd);
            
            if(maxStart <= minEnd) {
                resultList.add(new int[]{maxStart, minEnd});
            }
            
            if(minEnd == firstEnd) {
              i++;  
            } 
            if(minEnd == secondEnd) {
              j++;  
            } 
        }
        
        int[][] result = new int[resultList.size()][2];
        for(int l = 0; l < resultList.size(); l++) {
            result[l] = resultList.get(l);
        }
        return result;
    }
    
}