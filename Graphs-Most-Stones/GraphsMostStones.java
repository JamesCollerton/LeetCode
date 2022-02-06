class Solution {
    public int removeStones(int[][] stones) {
        
        int numberStones = stones.length;
        boolean[] visited = new boolean[numberStones];
        int numberGroups = 0;
        
        for(int i = 0; i < numberStones; i++) {
            if(!visited[i]) {
                dfs(i, stones, visited);
                numberGroups++;
            }
        }
        
        return numberStones - numberGroups;
    }
    
    private void dfs(int stoneIndex, int[][] stones, boolean[] visited) {
        if(visited[stoneIndex]) {
            return;
        }
        
        visited[stoneIndex] = true;
        int[] stone = stones[stoneIndex];
        
        for(int i = 0; i < stones.length; i++) {
            int[] connectedStone = stones[i];
            if(stone[0] == connectedStone[0] || stone[1] == connectedStone[1]) {
                dfs(i, stones, visited);
            }
        }
    }
}