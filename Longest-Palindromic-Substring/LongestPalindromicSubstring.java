class Solution {
    public String longestPalindrome(String s) {
                        
        char[] array = s.toCharArray();
        
        int index = 0;
        boolean twoWindow = false;
        
        String result = Character.toString(array[0]);
        
        while(index < array.length && !((index == array.length - 1) && twoWindow)) {
            
            // The current palindrome is just the letter we are on,
            // and we want the pointers to be either side of our
            // current index
            String currentPalindrome = Character.toString(array[index]);
            int p1 = index - 1;
            int p2 = index + 1;
            
            // This is the case where the center is two letters. We 
            // want to add the next letter onto our string and move
            // the second pointer along by one
            boolean twoWindowValid = (twoWindow && array[index] == array[index + 1]);
            
            if(twoWindowValid) {
                currentPalindrome += Character.toString(array[index + 1]);
                p2 = index + 2;
            }
            
            if(!twoWindow || twoWindowValid) {
                // While we've not moved the pointers off the array
                // and the two end points are matching, add them to
                // the result and move the pointers along one
                while(p1 >= 0 && p2 < array.length && array[p1] == array[p2]) {
                    currentPalindrome = array[p1] + currentPalindrome + array[p2];
                    p1--;
                    p2++;
                }

                // If we've created a new longer palindrome then we want
                // to put it as the result
                if(currentPalindrome.length() > result.length()) {
                    result = currentPalindrome;
                }
                
            }

            // We only want to move the index along each other time. We want
            // to do one test with a single character, 
            if(twoWindow) {
                index++;
            }
            twoWindow = !twoWindow;
        }
            
        return result;
    }
}