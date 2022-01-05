class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordToFreqMap = new HashMap<>();
        
        for(String word: words) {
            wordToFreqMap.put(word, wordToFreqMap.getOrDefault(word, 0) + 1);
        }
        
        Queue<String> queue = new PriorityQueue<>((a, b) -> wordToFreqMap.get(b) - wordToFreqMap.get(a));
            
        for(String word: wordToFreqMap.keySet()) {
            queue.add(word);
        }
        
        List<String> result = new LinkedList<>();
        
        while(!queue.isEmpty() && result.size() < k) {
            
            String word = queue.poll();
            Queue<String> wordQueue = new PriorityQueue<>();
            wordQueue.add(word);
            
            while(!queue.isEmpty() && wordToFreqMap.get(word) == wordToFreqMap.get(queue.peek())) {
                word = queue.poll();
                wordQueue.add(word);
            }
            
            while(!wordQueue.isEmpty() && result.size() < k) {
                result.add(wordQueue.poll());   
            }
            
        }
        
        return result;
    }

}