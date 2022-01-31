class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char[] charArray = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    charArray[i] = '.';
                } else {
                    stack.pop();
                }
            }
        }
        
        stack.clear();
        
        for(int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if(c == ')') {
                stack.push(c);
            } else if(c == '(') {
                if(stack.isEmpty()) {
                    charArray[i] = '.';
                } else {
                    stack.pop();
                }
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for(Character c: charArray) {
            if(c != '.')
            stringBuilder.append(c);
        }
        
        return stringBuilder.toString();
    }
}