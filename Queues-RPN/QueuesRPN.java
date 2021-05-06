class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (String currentToken: tokens){
                
            if("+".equals(currentToken)) {
                stack.push(stack.pop() + stack.pop());
            } else if("-".equals(currentToken)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second - first);
            } else if("*".equals(currentToken)) {
                stack.push(stack.pop() * stack.pop());
            } else if("/".equals(currentToken)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(currentToken));
            }
                
        }
        
        return stack.pop();
    }
}