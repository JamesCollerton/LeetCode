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

        for(String word: dictionary) {
            
            int sPointer = 0;
            int wPointer = 0;
            
            while(sPointer < s.length() && wPointer < word.length()) {
                if(s.charAt(sPointer) == word.charAt(wPointer)) {
                    sPointer++;
                    wPointer++;
                } else {
                    sPointer++;
                }
            }
            
            if(wPointer >= word.length()) {
                return word;
            }
            
        }

        return "";
    }

}