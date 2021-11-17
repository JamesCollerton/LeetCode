class Solution {
    
    private List<String> splitExpression = new ArrayList<>();
    
    public int calculate(String s) {
        return recurse(s.replaceAll("\\s+",""), 0, 0, '+');
    }
    
    private int recurse(String s, int pointer, int runningResult, char lastFunction) {
        
        int pointerEnd = pointer + 1;
        boolean isInt = true;
        
        // Will set pointerEnd to either the first character where it
        // isn't part of an int, and put the last valid int in the
        // result variable
        
        int result = 0;
        while(pointerEnd <= s.length() && isInt) {
            try { 
                result = Integer.parseInt(s.substring(pointer, pointerEnd));
                pointerEnd++;
            } catch(NumberFormatException e) { 
                isInt = false; 
            }
        }
        
        System.out.println("Result " + result);
        
        // If the pointer has reached the end of the string then
        // we don't need to do a function and can return result
        if(pointerEnd > s.length()) {
            return result;
        }
        
        // Otherwise find the function from the string. The pointer
        // end will be at the character         
        char function = s.charAt(pointerEnd - 1);
                
        switch(function) {
            case '*':
                result *= recurse(s, pointerEnd);
                break;
            case '+':
                result += recurse(s, pointerEnd);
                break;
            case '/':
                result /= recurse(s, pointerEnd);
                break;
            case '-':
                result -= recurse(s, pointerEnd);
                break;
        }
        
        return result;
    }
}