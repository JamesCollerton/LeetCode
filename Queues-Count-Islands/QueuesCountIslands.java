class Solution {
    
    private int gridHeight;
    private int gridWidth;
        
    public int numIslands(char[][] grid) {
        
        gridHeight = grid.length;
        gridWidth = grid[0].length;
        
        int islandCount = 0;
        
        for(int i = 0; i < gridHeight; i++) {
            for(int j = 0; j < gridWidth; j++) {    
                if(grid[i][j] != '0') {
                    System.out.println("Found i " + i + " j " + j);
                    islandCount++;
                    visitIsland(grid, i, j);
                }
            }
        }
        
        return islandCount;
    }
    
    private void visitIsland(char[][] grid, int i, int j) {                
        if(i >= 0 && i < gridHeight && j >= 0 && j < gridWidth && grid[i][j] == '1') {
            grid[i][j] = '0';
            visitIsland(grid, i + 1, j);
            visitIsland(grid, i - 1, j);
            visitIsland(grid, i, j + 1);
            visitIsland(grid, i, j - 1);
        }
    }
    
}