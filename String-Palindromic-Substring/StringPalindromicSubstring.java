class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        
        for(int pointer = 0; pointer < s.length(); pointer++) {
            
            int left = pointer;
            int right = pointer;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
            
            if(pointer > 0) {
                left = pointer - 1;
                right = pointer;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
            }
            
        }
        
        return count;
    }
}