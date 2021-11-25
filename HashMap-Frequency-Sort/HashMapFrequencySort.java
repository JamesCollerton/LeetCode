class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> charToCountMap = new HashMap<>();
        
        // Create map of characters to their count
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charToCountMap.containsKey(c)) {
                charToCountMap.put(c, charToCountMap.get(c) + 1);
            } else {
                charToCountMap.put(c, 1);
            }
        }
        
        Set<Integer> counts = new HashSet<>();
        Map<Integer, Set<Character>> countToCharMap = new HashMap<>();
        
        for (Map.Entry<Character, Integer> entry : charToCountMap.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            counts.add(i);
            if(countToCharMap.containsKey(i)) {
                countToCharMap.get(i).add(c);
            } else {
                Set<Character> set = new HashSet<>();
                set.add(c);
                countToCharMap.put(i, set);
            }
        }
        
        List<Integer> countList = new ArrayList<>(counts);
        Collections.sort(countList, Collections.reverseOrder());
        
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < countList.size(); i++) {
            
            int currentCount = countList.get(i);
            
            for(char c : countToCharMap.get(currentCount)) {
                for(int j = 0; j < currentCount; j++) {
                    stringBuilder.append(c);
                }
            }
        }
        
        return stringBuilder.toString();
    }
}