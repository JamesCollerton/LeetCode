class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        boolean[] firstCovered = createCoveredArray(firstList);
        boolean[] secondCovered = createCoveredArray(secondList);
        
        for(int i = 0; i < firstCovered.length; i++) {
            System.out.println(i + " " + firstCovered[i]);
        }
        
        for(int i = 0; i < secondCovered.length; i++) {
            System.out.println(i + " " + secondCovered[i]);
        }
        
        int minSize = Math.min(firstCovered.length, secondCovered.length);
        
        int pointer = 0;
        
        List<int[]> list = new ArrayList<>(); 
        
        while(pointer < minSize) {
            int[] interval = new int[2];
            while(pointer < minSize && (!firstCovered[pointer] || !secondCovered[pointer])) {
                pointer++;
            }
            if(pointer < minSize) {
                interval[0] = pointer;
                while(pointer < minSize && firstCovered[pointer] && secondCovered[pointer]) {
                    pointer++;
                }
                interval[1] = pointer - 1;
                list.add(interval);
            }
        }
        
        int[][] result = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private boolean[] createCoveredArray(int[][] list) {
        
        int size = list[list.length - 1][1];
                
        boolean[] covered = new boolean[size + 1];
        
        for(int i = 0; i < list.length; i++) {
            for(int j = list[i][0]; j <= list[i][1]; j++) {
                covered[j] = true;
            }
        }
        
        return covered;
    }
}