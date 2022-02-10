class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if(n == 0) {
            return 0;
        }
        
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(needle.equals(haystack.substring(i, i + n))) {
                return i;
            }
        }
        
        return -1;
    }
}