class Solution {
    public String longestCommonPrefix(String[] strs) {
        List<Character> commonPrefix = strs[0].chars()
                                            .mapToObj(c -> (char) c)
                                            .collect(Collectors.toList());
        
        for(int i = 1; i < strs.length; i++) {
            List<Character> newPrefix = new ArrayList<>();
            char[] nextWord = strs[i].toCharArray();
            
            int j = 0;
            while(
                j < nextWord.length && 
                j < commonPrefix.size() && 
                nextWord[j] == commonPrefix.get(j)
            ){
                newPrefix.add(nextWord[j]);
                j++;
            }
            commonPrefix = newPrefix;
        }
        return commonPrefix.stream().map(String::valueOf).collect(Collectors.joining());
    }
}