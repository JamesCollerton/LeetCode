class Solution {
    public int longestSubstring(String s, int k) {
        
        int result = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            
            int counter = 0;
            int[] counterArray = new int[26];
            
            for(int j = i; j < arr.length; j++) {
                
                counterArray[arr[j] - 'a']++;
                counter++;
                
                boolean valid = true;
                for(int l = 0; l < counterArray.length; l++) {
                    if(counterArray[l] != 0 && counterArray[l] < k) {
                        valid = false;
                    }
                }
                
                if(valid) {
                    result = result > counter ? result : counter;
                }
            }
            
        }
        
        return result;
    }
}