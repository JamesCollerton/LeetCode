public class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> charToFreqMap = new HashMap<Character, Integer>();
        for (char t : tasks) {
            charToFreqMap.put(t, charToFreqMap.getOrDefault(t, 0) + 1);
        }

        int result = 0;
        int cycleTime = n + 1;
        
        Queue<Integer> characterFrequenciesQueue = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i: charToFreqMap.values()) {
            characterFrequenciesQueue.add(i);
        }
        
        while(!characterFrequenciesQueue.isEmpty()) {
            
            int timeUsedInCycle = 0;
            List<Integer> frequenciesList = new LinkedList<>();
            
            for(int i = 0; i < cycleTime; i++) {
                if(!characterFrequenciesQueue.isEmpty()) {
                    frequenciesList.add(characterFrequenciesQueue.poll());
                    timeUsedInCycle++;
                }
            }
            
            for(int frequency: frequenciesList) {
                if(--frequency > 0) {
                    characterFrequenciesQueue.add(frequency);
                }
            }
            
            result += characterFrequenciesQueue.isEmpty() ? timeUsedInCycle : cycleTime;
        }
        
        return result;
    }
}