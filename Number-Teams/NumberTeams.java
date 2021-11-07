class Solution {
    public int numTeams(int[] rating) {
        
        int result = 0;
        
        for(int i = 0; i < rating.length; i++) {
            int leftLessThan = 0, leftGreaterThan = 0;
            int rightLessThan = 0, rightGreaterThan = 0;
            for(int j = 0; j < i; j++) {
                if(rating[j] < rating[i]) {
                    leftLessThan++;
                } else {
                    leftGreaterThan++;
                }
            }
            for(int j = i + 1; j < rating.length; j++) {
                if(rating[j] < rating[i]) {
                    rightLessThan++;
                } else {
                    rightGreaterThan++;
                }
            }
            
            result += leftLessThan * rightGreaterThan + leftGreaterThan * rightLessThan;
        }
        
        return result;
    }
}