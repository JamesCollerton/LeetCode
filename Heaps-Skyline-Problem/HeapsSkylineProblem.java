class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        Map<Integer, Integer> xToMaxMap = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        
        // int lastX = 0;
        
        for(int[] building: buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            
            // for(int i = left; i < right; i++) {
            //     xToMaxMap.put(i, Math.max(xToMaxMap.getOrDefault(i, 0), height));
            // }
            xToMaxMap.put(left, Math.max(xToMaxMap.getOrDefault(left, 0), height));
            xToMaxMap.put(right - 1, Math.max(xToMaxMap.getOrDefault(right - 1, 0), height));
            
            queue.offer(left);
            queue.offer(right - 1);
            // lastX = Math.max(lastX, right);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        int currentHeight = 0;
        
        while(!queue.isEmpty()) {
            int i = queue.poll();
            // System.out.println(i);
            int newHeight = xToMaxMap.getOrDefault(i, 0); 
            if(newHeight != currentHeight) {
                List<Integer> coordinates = List.of(i, newHeight);
                result.add(coordinates);
            }
            currentHeight = newHeight;
        }
        
        return result;
    }
}