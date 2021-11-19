class Solution {
    
    public int characterReplacement(String s, int k) {
        
        int result = 1;
        
        if(k > 0 && s.length() > 1) {
            char[] arr = s.toCharArray();
            arr[0] = arr[1];
            result = Math.max(result, recurse(arr, 1, k - 1, 1));
        }
        
        
        for(int i = 1; i < s.length(); i++) {
            result = Math.max(result, recurse(s.toCharArray(), i, k, 1));
        }
        
        return result;
    }
    
    private int recurse(char[] arr, int pointer, int k, int max) {
        
        if(pointer >= arr.length) {
            return max;
        } 
        
        if(arr[pointer] == arr[pointer - 1]) {
            return recurse(arr, pointer + 1, k, max + 1);
        } else {
            if(k > 0) {
                arr[pointer] = arr[pointer - 1];
                return recurse(arr, pointer + 1, k - 1, max + 1);
            }
        }
        
        return max;
    }
}