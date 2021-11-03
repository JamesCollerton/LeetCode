class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        List<List<Integer>> memoisation = new ArrayList<>();
        
        int min = 10000;
        
        for(int rowIndex = 0; rowIndex < triangle.size(); rowIndex++) {
            
            List<Integer> row = triangle.get(rowIndex);
            memoisation.add(new ArrayList<>());
            
            for(int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                
                int currentValue = row.get(columnIndex);
                
                if(rowIndex == 0) {
                    memoisation.get(rowIndex).add(currentValue);
                    if(rowIndex == triangle.size() - 1) {
                        min = currentValue;
                    }
                } else {
                    
                    int value;
                    List<Integer> previousRow = memoisation.get(rowIndex - 1);
                    
                    if(columnIndex - 1 < 0) {
                        value = previousRow.get(columnIndex);
                    } else if(columnIndex >= previousRow.size()) {
                        value = previousRow.get(columnIndex - 1);
                    } else {
                        value = min(
                            previousRow.get(columnIndex), 
                            previousRow.get(columnIndex - 1)
                        );
                    }
                    
                    int valueToAdd = value + currentValue;
                    if(rowIndex == triangle.size() - 1) {
                        min = min(valueToAdd, min);
                    }
                    memoisation.get(rowIndex).add(valueToAdd);
                }
            }
               
        }
        
        // int min = 100000;
        // List<Integer> lastRow = memoisation.get(memoisation.size() - 1);
        // for(int i = 0; i < lastRow.size(); i++) {
        //     min = min(min, lastRow.get(i));
        // }
        
        return min;
    }
    
    private int min(int a, int b) {
        return a < b ? a : b;
    }
}