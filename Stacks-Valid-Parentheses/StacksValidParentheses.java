class Solution {
        
    public boolean isValid(String s) {
        
        Stack<Character> openStack = new Stack<>();
        Stack<Character> closeStack = new Stack<>();
        
        HashMap<Character, Character> openCloseMap = new HashMap<>();
        openCloseMap.put('(', ')');
        openCloseMap.put('{', '}');
        openCloseMap.put('[', ']');
        
        for(char c: s.toCharArray()) {
            if(openCloseMap.containsKey(c)) {
                openStack.push(c);
            } else {
                closeStack.push(c);
            }
        }
        
        while(!openStack.isEmpty() && !closeStack.isEmpty()) {
            
            Character openBracket = openStack.pop();
            Character closeBracket = closeStack.pop();
            
            if(!closeBracket.equals(openCloseMap.get(openBracket))){
                return false;
            }
            
        }
        
        if(!closeStack.isEmpty() || !openStack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}