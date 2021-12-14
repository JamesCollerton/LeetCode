class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int result = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == i) {
                result++;
                max = Integer.MIN_VALUE;
            }
        }
        
        return result;
    }
}