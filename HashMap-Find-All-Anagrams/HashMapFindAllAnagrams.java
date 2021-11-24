class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s.length() < p.length()) {
            return result;
        }
        
        // Create the initial maps of p and s
        Map<Character, Integer> pMap = createMap(p);
        Map<Character, Integer> sMap = createMap(s.substring(0, p.length()));
        
        // We can optimise this by changing the sMap each time rather than totally
        // recalculating it
        int startOfWindow = 0;
        int endOfWindow = p.length();
        
        while(endOfWindow < s.length()) {
            
            if(mapContains(sMap, pMap) && mapContains(sMap, pMap)) {
                result.add(startOfWindow);
            }
            
            if(sMap.get(s.charAt(startOfWindow)) == 1) {
                sMap.remove(s.charAt(startOfWindow));
            }  else {
                sMap.put(s.charAt(startOfWindow), sMap.get(s.charAt(startOfWindow)) - 1);
            }
            
            int newEntry = 1;
            if(sMap.containsKey(s.charAt(endOfWindow))) {
                newEntry = sMap.get(s.charAt(endOfWindow)) + 1;
            }
            
            sMap.put(s.charAt(endOfWindow), newEntry);
            
            startOfWindow++;
            endOfWindow++;
        }
        
        if(mapContains(sMap, pMap) && mapContains(sMap, pMap)) {
            result.add(startOfWindow);
        }
        
        return result;
    }
    
    private boolean mapContains(Map<Character, Integer> a, Map<Character, Integer> b) {
        for (Map.Entry<Character, Integer> entry : a.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            if(!b.containsKey(c) || i != b.get(c)) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Character, Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        return map;
    }
}