class Solution {
    
    public String reorganizeString(String s) {
        
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }
        
        Queue<Character> queue = new PriorityQueue<>((a, b) -> charToFreqMap.get(b) - charToFreqMap.get(a));
        
        for(char c: charToFreqMap.keySet()) {
            queue.add(c);
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        Character previousChar = null;
        
        while(!queue.isEmpty()) {
            
            Character nextChar = queue.poll();
            
            if(queue.isEmpty()) {
                if(nextChar.equals(previousChar)) {
                    return "";
                } else {
                    stringBuilder.append(nextChar);
                    if(charToFreqMap.get(nextChar) != 1) {
                        charToFreqMap.put(nextChar, charToFreqMap.get(nextChar) - 1);
                        queue.add(nextChar);
                    }
                    previousChar = nextChar;
                }
            } else {
                Character nextNextChar = queue.poll();
                
                if(nextChar.equals(previousChar)) {
                    stringBuilder.append(nextNextChar);
                    stringBuilder.append(nextChar);
                    previousChar = nextChar;
                } else {
                    stringBuilder.append(nextChar);
                    stringBuilder.append(nextNextChar);
                    previousChar = nextNextChar;
                }
                
                if(charToFreqMap.get(nextChar) != 1) {
                    charToFreqMap.put(nextChar, charToFreqMap.get(nextChar) - 1);
                    queue.add(nextChar);
                }
                if(charToFreqMap.get(nextNextChar) != 1) {
                    charToFreqMap.put(nextNextChar, charToFreqMap.get(nextNextChar) - 1);
                    queue.add(nextNextChar);
                }
            }
        
        }
        
        return stringBuilder.toString();
    }
}