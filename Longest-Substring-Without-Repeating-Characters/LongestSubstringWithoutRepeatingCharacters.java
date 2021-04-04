class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Split into array of characters
        char[] charArray = s.toCharArray();
        
        int maxLength = 0;
        int position = 0;
        
        while(position <= charArray.length) {
            
            FindMaxSubstringLengthResult result = findMaxSubstringLength(
                charArray, 
                new HashMap<Character, Integer>(), 
                0,
                position
            );
            
            int potentialMaxLength = result.maxLength;
            position = result.nextPosition;
            
            maxLength = potentialMaxLength > maxLength ? potentialMaxLength : maxLength;
        
        }
        
        return maxLength;
    }
    
    // Max substring length finder (can this be recursive)
    private FindMaxSubstringLengthResult findMaxSubstringLength(
        char[] charArray, 
        HashMap<Character, Integer> seenCharHashMap, 
        int maxLength, 
        int position
    ) {
                
        // Break clause         
        if(charArray == null || charArray.length == 0 || position >= charArray.length) {
            return new FindMaxSubstringLengthResult(maxLength, position + 1);
        }
        
        // Check to see if current character has been seen
        char currentChar = charArray[position];
        
        // If it has then return current max length and index of first repetition
        if(seenCharHashMap.containsKey(currentChar)) {
            int firstRepetition = seenCharHashMap.get(currentChar);
            return new FindMaxSubstringLengthResult(maxLength, firstRepetition + 1);
        }
    
        // Otherwise increase max length by 1
        int newMaxLength = maxLength + 1;
    
        // Add current character to seen characters
        seenCharHashMap.put(currentChar, position);
    
        return findMaxSubstringLength(charArray, seenCharHashMap, newMaxLength, position + 1);
    }
    
    class FindMaxSubstringLengthResult {
        int maxLength;
        int nextPosition;
        FindMaxSubstringLengthResult(int maxLength, int nextPosition) {
            this.maxLength = maxLength;
            this.nextPosition = nextPosition;
        }
    }
}