class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> -(x - y));
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }
        
        return pq.peek();
    }
}