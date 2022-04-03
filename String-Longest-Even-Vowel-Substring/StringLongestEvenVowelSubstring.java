class Solution {
    
    private int max = 0;
    private Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    
    public int findTheLongestSubstring(String s) {
                                
        for(int i = 0; i < s.length(); i++) {
            dfs(s, i, 0, new HashSet<>());
        }
        
        return max;
    }
    
    private void dfs(String s, int i, int count, HashSet<Character> set) {
        if(set.isEmpty() && count > max) {
            max = count;
        }
        
        if(i >= s.length()) {
            return;
        }
        
        char c = s.charAt(i);
        if(vowels.contains(c)) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        
        dfs(s, i + 1, count + 1, set);
    }
}