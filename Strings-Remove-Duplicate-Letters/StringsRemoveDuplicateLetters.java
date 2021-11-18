class Solution {
        
    public String removeDuplicateLetters(String s) {

        // Counts the number of times different characters
        // appear
        int[] characterCount = new int[26];
        
        // Keep track of which characters have been visited
        boolean[] seen = new boolean[26];
        
        // Convert to array
        char[] arr = s.toCharArray();

        // Find the number of times we have visited the character
        for(char c: arr) {
            characterCount[c - 'a']++;
        }

        // Create a stack and an index
        Stack<Character> stack = new Stack<>();
        int index;

        // Go through all characters in array
        for(char c: arr) {

            // Get the index of the character
            index = c - 'a';
            
            // Decrease the count of the character
            characterCount[index]--;
            
            // If we've already seen it then skip it
            if(!seen[index]) {

                // While the stack is empty and this character is less than the next one
                // and we will still see the next character after this one
                while(!stack.isEmpty() && c < stack.peek() && characterCount[stack.peek() - 'a'] != 0) {
                    // Remove the character and say we haven't seen it
                    seen[stack.pop() - 'a'] = false;
                }
                
                // Add the character on
                stack.push(c);
                
                // Say we've visited it
                seen[c - 'a'] = true;
            }
            
        }

        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
        
    }

}