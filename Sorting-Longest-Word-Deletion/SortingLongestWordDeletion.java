class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, (a, b) -> {
            if(a.length() - b.length() > 0) {
                return -1;
            } else if(a.length() - b.length() < 0) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });
        
        Map<Character, Integer> charToCountMap = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            charToCountMap.put(c, charToCountMap.getOrDefault(c, 0) + 1);
        }
        
        // bappler
        // apple, bpple, app, bp, ting
        for(String word: dictionary) {
            
            Map<Character, Integer> wordCharToCountMap = new HashMap<>(charToCountMap);
                        
            boolean matches = true;
            
            for(char c: word.toCharArray()) {
                if(wordCharToCountMap.containsKey(c)) {
                    if(wordCharToCountMap.get(c) > 0) {
                        wordCharToCountMap.put(c, wordCharToCountMap.get(c) - 1);
                    } else {
                        matches = false;
                    }
                } else {
                    matches = false;
                }
            }
            
            if(matches) {
                return word;
            }
        }

        return "";
    }

}