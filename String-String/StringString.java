class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.isEmpty()) {
            return 0;
        }
        
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        
        for(int i = 0; i < haystackArray.length; i++) {
            
            if(needleArray[0] == haystackArray[i]) {
                
                boolean solution = true;
                
                for(int j = 0; j < needleArray.length; j++) {
                    
                    int haystackIndex = i + j;
                    solution = solution && 
                                (haystackIndex < haystackArray.length) &&
                                (needleArray[j] == haystackArray[haystackIndex]); 
                    
                }
                if(solution) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}