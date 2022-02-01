class Solution {
    public int reverse(int x) {
        
        int result = 0;
        
        while(x != 0) {
            int lastDigit = x % 10;
            int temp = result * 10 + lastDigit;
            if(result != (temp - lastDigit) / 10) {
                return 0;
            }
            result = temp;
            x = x / 10;
        }
        
        return result;
    }
    
}