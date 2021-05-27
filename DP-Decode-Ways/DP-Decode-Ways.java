class Solution {
        
    public int numDecodings(String s) {        
        if(s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int[] waysToArrive = new int[s.length() + 1];
        waysToArrive[0] = 1;
        waysToArrive[1] = 1;
        
        for(int i = 1; i < s.length(); i++) {
            
            int current = s.charAt(i) - '0';
            int previous = s.charAt(i - 1) - '0';
            
            boolean previousValid = (previous > 0 && (previous * 10 + current) <= 26);
            boolean currentValid = current > 0;
            
            if(!previousValid && !currentValid) {
                return 0;
            } else if(previousValid && currentValid) {
                waysToArrive[i + 1] = waysToArrive[i] + waysToArrive[i - 1];
            } else if(previousValid) {
                waysToArrive[i + 1] = waysToArrive[i - 1];
            } else {
                waysToArrive[i + 1] = waysToArrive[i];
            }
            
        }
       
        return waysToArrive[waysToArrive.length - 1];
    }
}