class Solution {

    public List<List<String>> partition(String s) {

        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        
        return result;
    }
    
    public void helper(String s, List<String> step, List<List<String>> result) {
        
        // We have only continued if this is a palindrome, so we know
        // we can add it
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        
        // We want to get all of the possible remaining substrings from
        // the string we have been passed.
        for(int i = 1; i <= s.length(); i++) {
            
            String temp = s.substring(0, i);
            
            if(isPalindrome(temp)) {  
                step.add(temp);  // choose
                helper(s.substring(i, s.length()), step, result); // explore
                step.remove(step.size() - 1); // unchoose
            }
        }
        return;
    }
    
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
    
}