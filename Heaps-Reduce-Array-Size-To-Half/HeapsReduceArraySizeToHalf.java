class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int num: arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        for(int key: frequencyMap.keySet()) {
            queue.offer(key);
        }
        
        int n = arr.length;
        int result = 0;
        
        while(n > arr.length / 2) {
            n -= frequencyMap.get(queue.poll());
            result++;
        }
        
        return result;
    }
}