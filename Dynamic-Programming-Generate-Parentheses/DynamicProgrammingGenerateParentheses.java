class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis("", 0, 0, n, list);
        return list;
    }
    
    private void generateParenthesis(String string, int open, int closed, int max, List<String> list) {
        if(string.length() == max * 2) {
            list.add(string);
        }
        if(open < max) {
            generateParenthesis(string + "(", open + 1, closed, max, list);
        }
        if(closed < open) {
            generateParenthesis(string + ")", open, closed + 1, max, list);
        }
    }
}