class Solution {
    public String longestPalindrome(String s) {
        
        // Can maybe see if we can adapt the later
        // logic to cover this case
        if(s.length() == 1) {
            return s;
        }
        
        char[] array = s.toCharArray();
        
        // Start the first pointer at the beginning of
        // the array, the second at the end
        int p1 = 0;
        int p2 = (array.length - 1);
        
        // Our starting solution can just be our first
        // character.
        String result = Character.toString(s.charAt(0));
        
        // If p1 has moved past the end of the array
        // then we can stop.
        while(p1 < array.length) {
            
            // Initialise two halves of a palindrome,
            // one working from the front, one working
            // from the back
            
            // Potential optimisation: string buffer
            String p1Half = "";
            String p2Half = "";
            
            // This is our flag to say when we have found a potential
            // palindrome.
            boolean started = false;
            
            // When we feel we've detected the start of a palindrome
            // we want to begin moving the first pointer along. However, if we
            // find that this isn't a palindrome we want to reset it and
            // put the second pointer back to the character before we
            // detected the start.
            int holderP1 = p1;
            int holderP2 = p2 - 1;
            
            // We then want to move the second pointer continually
            // back until we meet the first one. We need to be aware
            // of double counting as well.
            while(p1 <= p2) {
            
                // If we aren't currently looking for a palindrome and find
                // two matching pointers then we can initialise our palindrome
                // halves with these values. We also need to set our P2 holder
                // as if this doesn't turn out to be a palindrome then we will
                // move P1 back to the start and P2 back to the point before
                // we thought we found it.
                if(!started && array[p1] == array[p2]) {
                    p1Half += array[p1];
                    if(p1 != p2){
                        p2Half += array[p2];
                    }
                    holderP2 = p2;
                    started = true;
                }
                
                // If we're already looking and our next two characters match then
                // we can add them to our 
                else if(started && array[p1] == array[p2]) {
                    p1Half += array[p1];
                    if(p1 != p2) {
                        p2Half = array[p2] + p2Half;
                    }
                }
                
                else if(started && array[p1] != array[p2]) {
                    p1Half = "";
                    p2Half = "";
                    started = false;
                    p1 = holderP1;
                    p2 = holderP2;
                }
                
                if(started) {
                    p1++;
                }
                p2--;
            }
            
            // If the second pointer has gone past the
            // first one then we need to move the first
            // one along and the second one back to the
            // end.
            p1 = holderP1 + 1;
            p2 = (array.length - 1);
            String potentialPalindrome = p1Half + p2Half;
            if(potentialPalindrome.length() > result.length()) {
                result = potentialPalindrome;
            }
            
        }
        
        return result;
    }
}