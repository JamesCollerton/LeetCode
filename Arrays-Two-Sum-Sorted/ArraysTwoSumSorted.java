class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointerOne = 0;
        int pointerTwo = numbers.length - 1;
        
        int value = numbers[pointerOne] + numbers[pointerTwo];
        
        while(value != target) {
            
            value = numbers[pointerOne] + numbers[pointerTwo];
            
            if(value < target) {
                pointerOne++;
            } else if(value > target) {
                pointerTwo--;
            }
        }
        
        return new int[]{pointerOne + 1, pointerTwo + 1};
    }
}