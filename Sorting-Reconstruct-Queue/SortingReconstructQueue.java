class Solution {
    
    private final int HEIGHT = 0;
    private final int POSITION = 1;
    
    public int[][] reconstructQueue(int[][] people) {
        
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if(a[HEIGHT] > b[HEIGHT]) {
                return -1;
            } else if(a[HEIGHT] < b[HEIGHT]) {
                return 1;
            } else {
                if(a[POSITION] < b[POSITION]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        
        for(int[] person: people) {
            queue.offer(person);
        }
        
        List<int[]> result = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int[] person = queue.poll();
            result.add(person[POSITION], person);
        }
        
        return result.toArray(new int[people.length][]);
    }
}