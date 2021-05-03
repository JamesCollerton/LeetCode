class Solution {
    
    private int gridHeight;
    private int gridWidth;
    private boolean[][] visitedGrid;
        
    public int numIslands(char[][] grid) {
        
        gridHeight = grid.length;
        gridWidth = grid[0].length;
        
        visitedGrid = new boolean[gridHeight][gridWidth];
        int islandCount = 0;
        
        for(int i = 0; i < gridHeight; i++) {
            for(int j = 0; j < gridWidth; j++) {
                
                if(!visitedGrid[i][j]) {
                    
                    visitedGrid[i][j] = true;
                    
                    if(grid[i][j] != '0') {
                        islandCount++;
                        visitIsland(grid, i, j);
                    }
                }
                
            }
        }
        
        return islandCount;
    }
    
    private void visitIsland(char[][] grid, int i, int j) {
                
        Queue<Coordinates> squaresToVisit = new LinkedList();
        Coordinates startCoordinates = new Coordinates(i, j);
        squaresToVisit.add(startCoordinates);
        
        while(!squaresToVisit.isEmpty()) {
            
            Coordinates currentCoordinates = squaresToVisit.remove(); 
            visitedGrid[currentCoordinates.i][currentCoordinates.j] = true;
            
            for(int iIncrement = -1; iIncrement <= 1; iIncrement++) {
                for(int jIncrement = -1; jIncrement <= 1; jIncrement++) {
                    
                    if(!(iIncrement == jIncrement) &&
                       !(iIncrement + jIncrement == 0) ) {
                        
                        int newI = currentCoordinates.i + iIncrement;
                        int newJ = currentCoordinates.j + jIncrement;
                        
                        if((newI >= 0 && newI < gridHeight) &&
                           (newJ >= 0 && newJ < gridWidth)) {
                            
                            if(!visitedGrid[newI][newJ] && grid[newI][newJ] == '1') {
                                Coordinates newCoordinates = new Coordinates(newI, newJ);
                                squaresToVisit.add(newCoordinates);
                            }
                        }
                    }
                }
            }
        }
        
        
    }
    
    private class Coordinates {
        int i;
        int j;
        Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
}