class Solution {
    
    public int characterReplacement(String s, int k) {
        
        // This is the count of letters in the current window
        int[] freq = new int[26];
        
        // This is the most frequent letter in the window
        int mostFreqLetter = 0;
        
        // Start off at the left
        int left = 0;
        
        // Max to be returned
        int max = 0;

        // Start at first character
        for(int right = 0; right < s.length(); right++){
            // Increase the character count at the right
            freq[s.charAt(right) - 'A']++;
            
            // Change most frequent letter depending on the new character on right
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            // This is the number of characters to change, all in the window apart 
            // from the most frequent one
            int lettersToChange = (right - left + 1) - mostFreqLetter;
            
            // If we can't change it then move the left pointer along
            if(lettersToChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
    
            // Max is now the maximum or this window             
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    
}