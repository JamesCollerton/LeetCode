class Solution {
    public int maxProduct(int[] nums) {
        
        // You only ever want to leave out one negative
        // number, the first or the last one. If there are
        // an even number we can include all of them to
        // maximise the product
        
        int max = Integer.MIN_VALUE;
        int product = 1;
        
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(product, max);
            product = product == 0 ? 1 : product;
        }
        
        product = 1;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(product, max);
            product = product == 0 ? 1 : product;
        }
        
        return max;
    }
}