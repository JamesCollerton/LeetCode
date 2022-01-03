class Solution {
    
    Map<Integer, Integer> integerToFrequencyMap = new HashMap<>();
    
    public int[] topKFrequent(int[] nums, int k) {
                
        Comparator<Integer> comparator = new FrequencyComparator();
        Queue<Integer> queue = new PriorityQueue<>(
            (x, y) -> integerToFrequencyMap.get(x) - integerToFrequencyMap.get(y)
        );
        
        for(int i: nums) {
            integerToFrequencyMap.put(i, integerToFrequencyMap.getOrDefault(i, 0) + 1);
        }
        
        for(int i: integerToFrequencyMap.keySet()) {
            queue.add(i);
            if(queue.size() > k) {
                queue.remove();
            }
        }
                
        int[] result = new int[k];
        int i = 0;
        while(i < k) {
            result[i] = queue.poll();
            i++;
        }
        return result;
    }
}