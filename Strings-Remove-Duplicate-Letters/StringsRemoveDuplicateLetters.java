class Solution {
    public String removeDuplicateLetters(String s) {
        
        Set<Character> set = new HashSet<>();
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        
        List<Character> list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        return list.stream().map(c -> c.toString()).collect(Collectors.joining(""));
    }
}