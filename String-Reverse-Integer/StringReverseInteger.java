class Solution {
    public int reverse(int x) {
        
        int result = 0;
        
        while(x != 0) {
            
            int lastDigit = x % 10;
            x /= 10;
            
            int before = result;
            result = 10 * result + lastDigit;
            int after = (result - lastDigit) / 10;
            if(before != after) {
                return 0;
            }
        }
        
        return result;
    }
    
}