class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse(n, 0, 0, result, "");
        return result;
    }
    
    private void recurse(int n, int numOpen, int numClosed, List<String> list, String str) {
        
        if(numOpen == n && numClosed == n) {
            list.add(str);
            return;
        }
        
        if(numOpen == numClosed) {
            recurse(n, numOpen + 1, numClosed, list, str + "(");
        } else {
            if(numOpen < n) {
                recurse(n, numOpen + 1, numClosed, list, str + "(");
            }
            recurse(n, numOpen, numClosed + 1, list, str + ")");
        }
        
    }

}