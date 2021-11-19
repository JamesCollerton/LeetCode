class Solution {
    public String decodeString(String s) {
        
        char[] arr = s.toCharArray();
        String result = "";
        
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        
        int i = 0;
        
        while(i < arr.length) {
            
            // When we get to a character we want to start
            // adding to it until it is finished, then push
            // it onto the stack
            if(Character.isDigit(arr[i])) {
                
                int num = 0;
                
                while(Character.isDigit(arr[i])) {
                    num = num * 10 + (arr[i] - '0');
                    i++;
                }
                
                numberStack.push(num);
                
            // If we get to an open bracket we are starting
            // a new string
            } else if(arr[i] == '[') {
                
                stringStack.push(result);
                result = "";
                i++;
                
            // Otherwise get whatever we have been working on,
            // and add it x times to the last string in the
            // stack
            } else if(arr[i] == ']') {
                
                // Basically we want to get the last string
                // from the stack and append the current string
                // onto it x times
                StringBuilder newResult = new StringBuilder(stringStack.pop());
                int repeatTimes = numberStack.pop();
                
                for (int j = 0; j < repeatTimes; j++) {
                    newResult.append(result);
                }
                
                // This is now what we're looking at, what we consider
                // to be in the middle of the brackets
                result = newResult.toString();
                i++;
                
            } else {
                
                // If it's a character just add to the 
                // string
                result += arr[i];
                i++;
                
            }
            
        }
        
        return result;
    }
}