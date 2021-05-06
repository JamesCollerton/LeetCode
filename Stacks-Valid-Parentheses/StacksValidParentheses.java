class Solution {
        
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        HashMap<Character, Character> openCloseMap = new HashMap<>();
        openCloseMap.put('(', ')');
        openCloseMap.put('{', '}');
        openCloseMap.put('[', ']');
        
        for(char c: s.toCharArray()) {
            if(openCloseMap.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character lastC = stack.pop();
                if(!openCloseMap.containsKey(lastC) || !openCloseMap.get(lastC).equals(c)){
                    return false;
                }
            }
        }
        
        if(!stack.isEmpty()) {
            return false;
        }
                
        return true;
    }
}