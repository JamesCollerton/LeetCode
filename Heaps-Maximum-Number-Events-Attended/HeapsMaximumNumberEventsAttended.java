class Solution {
    
    public int maxEvents(int[][] arr) {
        
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        int result = 0;
        
        for(int j = 0; j <= 100000; j++) {
            while(!queue.isEmpty() && queue.peek()[1] < j) {
                queue.poll();
            }
            while(i < arr.length && arr[i][0] == j) {
                queue.offer(arr[i++]);
            }
            if (!queue.isEmpty()) {
                queue.poll();
                result++;
            }
        }
        
        return result;
    }
}