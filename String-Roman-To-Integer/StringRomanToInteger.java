class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> charToValueMap = new HashMap<>();
        charToValueMap.put('I', 1);
        charToValueMap.put('V', 5);
        charToValueMap.put('X', 10);
        charToValueMap.put('L', 50);
        charToValueMap.put('C', 100);
        charToValueMap.put('D', 500);
        charToValueMap.put('M', 1000);
        
        Map<Character, Set<Character>> charToSubstituteMap = new HashMap<>();
        charToSubstituteMap.put('I', Set.of('V', 'X'));
        charToSubstituteMap.put('X', Set.of('L', 'C'));
        charToSubstituteMap.put('C', Set.of('D', 'M'));
        
        Character currentCharacter = null;
        int pointer = 0;
        char[] arr = s.toCharArray();
        int result = 0;
        
        while(pointer < arr.length) {
            currentCharacter = arr[pointer];
            if(pointer + 1 < arr.length && 
                charToSubstituteMap.containsKey(currentCharacter) &&
                charToSubstituteMap.get(currentCharacter).contains(arr[pointer + 1])) {
                result += charToValueMap.get(arr[pointer + 1]) - charToValueMap.get(currentCharacter);
                pointer = pointer + 2;
            } else {
                while(pointer < arr.length && arr[pointer] == currentCharacter) {
                    result += charToValueMap.get(currentCharacter);
                    pointer++;
                }      
            }
        }
        
        return result;
    }
}