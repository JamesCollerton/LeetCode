class Solution {
    public boolean isPalindrome(int x) {
        char [] array = String.valueOf(x).toCharArray();
        
        int p1 = 0;
        int p2 = array.length - 1;
        boolean isPalindrome = true;
        
        while(p1 < p2 && isPalindrome) {
            isPalindrome = (array[p1] == array[p2]);
            p1++;
            p2--;
        }
        
        return isPalindrome;
    }
}