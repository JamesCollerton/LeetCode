class Solution {
    public String smallestSubsequence(String s) {
        
        int[] lastAppearance = new int[26];
        
        char[] charArray = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int cIndex = c - 'a';
            lastAppearance[cIndex] = i;
            characters.add(c);
        }
        
        int previous = -1;
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while(!characters.isEmpty()) {
            
            int minIndex = s.length() + 1;
            for(Character c: characters) {
                minIndex = Math.min(lastAppearance[c - 'a'], minIndex);
            }
            
            Character minChar = null;
            int previousIndex = -1;
            for(int i = previous + 1; i <= minIndex; i++) {
                if(characters.contains(charArray[i])) {
                    if(minChar == null || charArray[i] < minChar) {
                        minChar = charArray[i];
                        previousIndex = i;
                    }
                }
            }
                                    
            stringBuilder.append(minChar);
            characters.remove(minChar);
            previous = previousIndex;
        }
        
        
        return stringBuilder.toString();
    }
}