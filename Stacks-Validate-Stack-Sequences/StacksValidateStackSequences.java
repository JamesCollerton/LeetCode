class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<>();
        
        int pushIndex = 0;
        int popIndex = 0;
        
        while(popIndex < popped.length) {
            
            if(stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if(pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex]);
                    pushIndex++;
                } else {
                    popIndex = popped.length + 1;
                }
            } else {
                stack.pop();
                popIndex++;
            }
            
        }
        
        return stack.isEmpty();
    }
}