class Solution {
    public int numSplits(String s) {
        
        int result = 0;
        
        Map<Character, Integer> leftCharToCountMap = new HashMap<>();
        Map<Character, Integer> rightCharToCountMap = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            rightCharToCountMap.put(c, rightCharToCountMap.getOrDefault(c, 0) + 1);
            leftCharToCountMap.put(c, 0);
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            rightCharToCountMap.put(c, rightCharToCountMap.get(c) - 1);
            leftCharToCountMap.put(c, leftCharToCountMap.get(c) + 1);
            
            long rightChars = rightCharToCountMap.values().stream().filter(x -> x > 0).count();
            long leftChars = leftCharToCountMap.values().stream().filter(x -> x > 0).count();
            
            if(rightChars == leftChars) {
                result++;
            }
        }
        
        return result;
    }
}