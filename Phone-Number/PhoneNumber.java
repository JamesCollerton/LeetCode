class Solution {
    
    // Potentially replace this with fancy character maths
    Map<Character, List<Character>> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        
        // Create a map of the character to list of characters
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
                
        // Return the list from the function
        return recurse(new ArrayList<String>(), digits.toCharArray(), 0);
    }
    
    private List<String> recurse(List<String> list, char[] digitArr, int pointer) {
        if(pointer > digitArr.length - 1) {
            return list;
        }
        
        List<Character> charList = map.get(digitArr[pointer]);
        
        List<String> newList = new ArrayList<>();
        
        if(list.isEmpty()) {
            for(int i = 0; i < charList.size(); i++) {
                newList.add(Character.toString(charList.get(i)));
            }
        } else {
            for(int i = 0; i < charList.size(); i++) {
                for(int j = 0; j < list.size(); j++) {
                    newList.add(list.get(j) + charList.get(i));
                }
            }
        }
        
        // Array copy could maybe be optimised using pointers      
        return recurse(newList, digitArr, pointer + 1);
    } 
}