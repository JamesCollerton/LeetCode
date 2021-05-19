class Solution {
    public String shortestPalindrome(String s) {
    
        char[] array = s.toCharArray();
        
        int indent = 0;
        char[] currentArray = array;
        
        while(!isPalindrome(currentArray)) {
            indent++;
            currentArray = Arrays.copyOfRange(array, 0, array.length - indent);
        }
        
        String result = String.valueOf(array);
        
        for(int i = indent; i > 0; i--) {
            result = array[array.length - i] + result;
        }
        
        return result;
    }
    
    private boolean isPalindrome(char[] array) {
        int pointerOne = 0;
        int pointerTwo = (array.length - 1);
        
        boolean isPalindrome = true;
        while(pointerOne <= pointerTwo && isPalindrome) {
            isPalindrome = array[pointerOne] == array[pointerTwo];
            pointerOne++;
            pointerTwo--;
        }
        return isPalindrome;
    }
}