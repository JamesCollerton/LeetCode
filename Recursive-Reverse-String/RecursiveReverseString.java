class Solution {
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
    
    private void helper(int p1, int p2, char[] s) {
        if(p1 >= p2) {
            return;
        }
        
        char temp = s[p2];
        s[p2] = s[p1];
        s[p1] = temp;
        helper(p1 + 1, p2 - 1, s);
    }
}