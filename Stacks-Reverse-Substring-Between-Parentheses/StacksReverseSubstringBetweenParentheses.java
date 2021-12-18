class Solution {
    public String reverseParentheses(String s) {
        
        StringBuilder currentStringBuilder = new StringBuilder();
        
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if('(' == arr[i]) {
                stack.push(currentStringBuilder.toString());
                currentStringBuilder = new StringBuilder();
            } else if(')' == arr[i]) {
                String reversed = currentStringBuilder.reverse().toString();
                currentStringBuilder = new StringBuilder(stack.pop() + reversed);
            } else {
                currentStringBuilder.append(arr[i]);
            }
        }
        
        return currentStringBuilder.toString();
    }
}