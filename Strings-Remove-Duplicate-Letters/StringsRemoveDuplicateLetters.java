class Solution {
    
    private boolean[] seen = new boolean[26];
    
    public String removeDuplicateLetters(String s) {
        
        int[] lastLetterAppearance = new int[26];
        
        for(int i = 0; i < lastLetterAppearance.length; i++) {
            lastLetterAppearance = -1;
        }
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; arr.length; i++) {
            lastLetterAppearance[arr[i] - 'a'] = i;
        }
        
        return recurse(lastLetterAppearance, 0);
    }
    
    private String recurse(int[] lastLetterAppearance, int pointer) {
        if(pointer >= lastLetterAppearance.size() || seen[pointer] || lastLetterAppearance[pointer] == -1) {
            return "";
        }
                
        int[] newLastLetterAppearance = new int[26];
        int currentLastLetterAppearance = lastLetterAppearance[pointer]
        
        for(int i = pointer + 1; i < lastLetterAppearance.length; i++) {
            if(
                lastLetterAppearance[i] != -1 && 
                lastLetterAppearance[i] < currentLastLetterAppearance &&
                !seen[i]
            ) {
                newLastLetterAppearance[i] = lastLetterAppearance[i];
            } else {
                newLastLetterAppearance[i] = -1;
            }
        }
        
        seen[pointer] = true;
        
        return Character.toString('a' + pointer) + recurse(lastLetterAppearance, pointer + 1);
    }
}