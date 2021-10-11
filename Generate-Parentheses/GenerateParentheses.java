class Solution {
    public List<String> generateParenthesis(int n) {
        return recurse(n, 0, 0, new ArrayList<String>());
    }
    
    private List<String> recurse(int n, int numOpen, int numClosed, List<String> list) {
        
        if(numOpen == n && numClosed == n) {
            return list;
        }
        
        if(numOpen == numClosed) {
            return addOpenBracket(n, numOpen, numClosed, list);
        } else {
            List<String> openBracketList = new ArrayList<>();
            if(numOpen < n) {
                openBracketList = addOpenBracket(n, numOpen, numClosed, list);
            }
            List<String> closedBracketList = addClosedBracket(n, numOpen, numClosed, list);
            openBracketList.addAll(closedBracketList);
            return openBracketList;
        }
        
    }
    
    private List<String> addOpenBracket(int n, int numOpen, int numClosed, List<String> list) {
        List<String> newList = new ArrayList<>();

        if(list.isEmpty()) {
            newList.add("(");
        } else {
            for(int i = 0; i < list.size(); i++) {
                newList.add(list.get(i) + "(");
            }
        }
        return recurse(n, numOpen + 1, numClosed, newList);
    }
    
    private List<String> addClosedBracket(int n, int numOpen, int numClosed, List<String> list) {
        List<String> newList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            newList.add(list.get(i) + ")");
        }
        return recurse(n, numOpen, numClosed + 1, newList);
    }
}