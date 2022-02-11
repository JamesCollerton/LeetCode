class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> characterToCountMap = new HashMap<>();
        int numberOdds = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            int cCount = characterToCountMap.getOrDefault(c, 0);
            if(cCount % 2 == 1) {
                numberOdds--;
            } else {
                numberOdds++;
            }
            cCount++;
            characterToCountMap.put(c, cCount);
        }
        
        int result = 0;
        for(int count: characterToCountMap.values()) {
            result += count;
        }
        
        return numberOdds > 0 ? result - numberOdds + 1 : result;
    }
}