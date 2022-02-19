class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        Map<Character, Integer> sCharCountMap = creatCharCountMap(s);
        
        String result = "";
        
        for(String word: dictionary) {
            Map<Character, Integer> wordCharCountMap = creatCharCountMap(word);
            boolean solution = true;
            for(Map.Entry<Character, Integer> entry: wordCharCountMap.entrySet()) {
                char c = entry.getKey();
                int val = entry.getValue();
                if(!(sCharCountMap.containsKey(c) && sCharCountMap.get(c) >= val)) {
                    solution = false;
                }
            }
            if(solution) {
                if(word.length() > result.length()) {
                    result = word;
                } else if(word.length() == result.length()){
                    result = result.compareTo(word) < 0 ? result : word;
                }
            }
        }
        
        return result;
    }
    
    private Map<Character, Integer> creatCharCountMap(String string) {
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for(char c: string.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        return charCountMap;
    }
}