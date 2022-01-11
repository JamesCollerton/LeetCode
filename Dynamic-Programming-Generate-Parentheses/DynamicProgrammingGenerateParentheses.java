class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        
        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(1, Set.of("()"));
        int counter = 2;
        
        while(counter <= n) {
            
            Set<String> set = new HashSet<>();
            
            Set<String> belowSet = map.get(counter - 1);
            
            for(String string: belowSet) {
                set.add("(" + string + ")");
            }
            
            for(int i = 1; i <= counter / 2; i++) {
                int remainder = counter - i;
                
                Set<String> iSet = map.get(i);
                Set<String> remainderSet = map.get(remainder);
                
                for(String iString: iSet) {
                    for(String rString: remainderSet) {
                        set.add(iString + rString);
                        set.add(rString + iString);
                    }
                }
            }
            
            map.put(counter, set);
            
            counter++;
        }
        
        result.addAll(map.get(n));
        
        return result;
    }
}