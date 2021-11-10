class Solution {
        
    public boolean isValid(String s) {
        
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']') {
                if(stack.empty()) {
                    return false;
                } else {
                    if(c == ')' && stack.pop() != '(') {
                        return false;
                    } else if(c == '}' && stack.pop() != '{') {
                        return false;
                    } else if(c == ']' && stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        
        return stack.empty();
    }
}