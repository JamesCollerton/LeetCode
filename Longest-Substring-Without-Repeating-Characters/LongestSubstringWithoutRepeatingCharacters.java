class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Split into array of characters
        char[] charArray = s.toCharArray();
        
        int maxLength = 0;
        
        // Loop through all characters
        for(int i = 0; i < charArray.length; i++) {
            char[] subArray = Arrays.copyOfRange(charArray, i, charArray.length);
            if(subArray.length <= maxLength) {
                break;    
            }
            int potentialMaxLength = findMaxSubstringLength(subArray, new HashSet<Character>(), 0);
            maxLength = potentialMaxLength > maxLength ? potentialMaxLength : maxLength;
        }
        
        return maxLength;
    }
    
    // Max substring length finder (can this be recursive)
    private int findMaxSubstringLength(char[] charArray, HashSet<Character> seenCharHashSet, int maxLength) {
        // Break clause         
        if(charArray == null || charArray.length == 0) {
            return maxLength;
        }
        
        // Check to see if current character has been seen
        char currentChar = charArray[0];
        
        // If it has then return current max length
        if(seenCharHashSet.contains(currentChar)) {
            return maxLength;
        }
    
        // Otherwise increase max length by 1
        int newMaxLength = maxLength + 1;
    
        // Add current character to seen characters
        seenCharHashSet.add(currentChar);
    
        // Call with the next substring
        char[] subArray = Arrays.copyOfRange(charArray, 1, charArray.length);
        
        return findMaxSubstringLength(subArray, seenCharHashSet, newMaxLength);
    }
}