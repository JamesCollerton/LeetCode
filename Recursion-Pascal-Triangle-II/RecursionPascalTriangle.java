class Solution {
    
    int[][] memoisation = new int[35][35];
    
    public List<Integer> getRow(int rowIndex) {
        
        // We have
        // f(row, column) = f(row − 1, column − 1) + f(row − 1, column - 1)
        // f(row, column) = 1 where column = 1 or row = column
        
        List<Integer> rowList = new ArrayList<>();
        initialiseMemoisation();
            
        int row = 1;
        
        while(rowIndex >= 0) {
            rowList = new ArrayList<>();
            int col = 1;
            while(col <= row) {
                int val = findValue(row, col);
                rowList.add(val);
                memoisation[row][col] = val;
                col++;
            }
            rowIndex--;
            row++;
        }
        
        return rowList;
    }
    
    private void initialiseMemoisation() {
        for(int i = 0; i < memoisation.length; i++) {
            for(int j = 0; j < memoisation[i].length; j++) {
                memoisation[i][j] = -1;
            }
        }
    }
    
    private int findValue(int row, int col) {
        if(col == 1 || row == col) {
            return 1;
        }
        
        if(memoisation[row][col] != -1) {
            return memoisation[row][col];
        }
        
        return findValue(row - 1, col - 1) + findValue(row - 1, col);
    }
}