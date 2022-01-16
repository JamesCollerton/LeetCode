class Solution {
    
    private int max = 0;
    private List<Coordinates> moves = List.of(
        new Coordinates(1, 0),
        new Coordinates(0, 1),
        new Coordinates(-1, 0),
        new Coordinates(0, -1)
    );
    private Map<Coordinates, List<Coordinates>> adjacencyList = new HashMap<>();
    
    private class Coordinates {
        int row;
        int col;
        int val;
        Coordinates(int row, int col) {
            this.row = col;
            this.col = col;
        }
        Coordinates(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public boolean equals(Object o) {
            Coordinates that = (Coordinates) o;
            return this.row == row && this.col == col;
        }
    }
    
    public int longestIncreasingPath(int[][] matrix) {
                
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                Coordinates coordinates = new Coordinates(i, j, matrix[i][j]);
                System.out.println(i);
                System.out.println(j);
                adjacencyList.put(coordinates, new ArrayList<>());
                for(Coordinates move: moves) {
                    int newRow = i + move.row;
                    int newCol = j + move.col;
                    if(newRow >= 0 && newCol >= 0 && newRow < numRows && newCol < numCols) {
                        adjacencyList.get(coordinates).add(new Coordinates(newRow, newCol, matrix[newRow][newCol]));
                    }
                }
            }
        }
        
        for(Map.Entry<Coordinates, List<Coordinates>> entry: adjacencyList.entrySet()) {
            System.out.println(entry.getKey().row + " " + entry.getKey().col); 
        }
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                dfs(new Coordinates(i, j), new HashSet<Coordinates>(), 0);
            }
        }
        
        return max;
    }
    
    private void dfs(Coordinates coordinates, Set<Coordinates> seen, int currentMax) {
        
        seen.add(coordinates);
        
        max = Math.max(currentMax + 1, max);
        
        System.out.println(coordinates.row);
        System.out.println(coordinates.col);
        
        for(Coordinates moveTo: adjacencyList.get(coordinates)) {
            if(!seen.contains(moveTo)) {
                dfs(moveTo, new HashSet<>(seen), currentMax + 1);
            }
        }
        
    }
}