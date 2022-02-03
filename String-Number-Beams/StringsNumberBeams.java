class Solution {
    public int numberOfBeams(String[] bank) {
        
        int previousOnes = 0;
        int result = 0;
        
        for(String row: bank) {
            int numberOnes = 0;
            for(char c: row.toCharArray()) {
                if(c == '1') {
                    numberOnes++;
                }
            }
            if(numberOnes > 0) {
                result += previousOnes * numberOnes;
                previousOnes = numberOnes;
            }
        }
        
        return result;
    }
}