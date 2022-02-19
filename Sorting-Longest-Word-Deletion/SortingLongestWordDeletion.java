class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String result = "";
        
        for(String word: dictionary) {
            
            int sPointer = 0;
            int wPointer = 0;
            
            while(sPointer < s.length() && wPointer < word.length()) {
                while(sPointer < s.length() && s.charAt(sPointer) != word.charAt(wPointer)) {
                    sPointer++;    
                }
                if(sPointer < s.length()) {
                    sPointer++;
                    wPointer++;
                }
            }
            
            if(wPointer >= word.length()) {     
                if(word.length() > result.length()) {
                    result = word;
                } else if(word.length() == result.length()){
                    result = result.compareTo(word) < 0 ? result : word;
                }
            }
        }
        
        return result;
    }

}