class Solution {
        
    public int numDecodings(String s) {
        int[] array = s.chars()
                            .map(Character::getNumericValue)
                            .toArray();
       
        return createNode(array, 0);
    }
    
    private int createNode(int[] array, int index) {
        
        if(index >= array.length) {
            return 1;
        }
        int potentialLeft = array[index];
        if(potentialLeft == 0) {
            return 0;
        }
        int result = createNode(array, index + 1);
        if(index + 1 < array.length) {
            int potentialRight = 10 * array[index] + array[index + 1];
            if(potentialRight <= 26) {
                result += createNode(array, index + 2);
            }
        }
        
        return result;
    }
}