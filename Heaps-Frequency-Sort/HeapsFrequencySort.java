class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }
        
        Queue<Character> queue = new PriorityQueue<>((a, b) -> charToFreqMap.get(b) - charToFreqMap.get(a));
        
        for(char c: charToFreqMap.keySet()) {
            queue.add(c);
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while(!queue.isEmpty()) {
            char c = queue.poll();
            int freq = charToFreqMap.get(c);
            for(int i = 0; i < freq; i++) {
                stringBuilder.append(c);
            }
        }
        
        return stringBuilder.toString();
    }
}