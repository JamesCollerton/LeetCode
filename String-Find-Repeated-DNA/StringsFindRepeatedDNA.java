class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if(seen.contains(substring)) {
                result.add(substring);
            }
            seen.add(substring);
        }
        
        return new ArrayList<>(result);
    }
}