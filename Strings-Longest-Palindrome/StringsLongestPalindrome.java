class Solution {
        
    public int longestPalindrome(String[] words) {
        
        HashMap<String, Integer> forwardWordToCountMap = new HashMap<>();
        
        int countOfUnpairedBrackets = 0;
        int result = 0;
        
        for(String word: words) {
            
            if(!forwardWordToCountMap.containsKey(word)) {
                forwardWordToCountMap.put(word, 0);
            }
            
            if(word.charAt(0) != word.charAt(1)) {
                
                String reverseWord = Character.toString(word.charAt(1)) + Character.toString(word.charAt(0));
                
                if(forwardWordToCountMap.containsKey(reverseWord) && forwardWordToCountMap.get(reverseWord) > 0) {
                    forwardWordToCountMap.put(reverseWord, forwardWordToCountMap.get(reverseWord) - 1);
                    result += 4;
                } else {
                    forwardWordToCountMap.put(word, forwardWordToCountMap.get(word) + 1);
                }
            } else {
                
                if(forwardWordToCountMap.get(word) > 0) {
                    forwardWordToCountMap.put(word, forwardWordToCountMap.get(word) - 1);  
                    countOfUnpairedBrackets--;
                    result += 4;
                } else {
                    forwardWordToCountMap.put(word, forwardWordToCountMap.get(word) + 1);
                    countOfUnpairedBrackets++;
                }
                
            }
        }
        
        return countOfUnpairedBrackets > 0 ? result + 2 : result;
    }
}