class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        
        int start = 0;
        int end = 9;
                
        while(end < s.length()) {
            String subsequence = s.substring(start, end + 1);
            if(seen.contains(subsequence)) {
                result.add(subsequence);
            } else {
                seen.add(subsequence);
            }
            start++;
            end++;
        }
        
        return new ArrayList<>(result);
    }
}