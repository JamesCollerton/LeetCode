class Solution {
    public int maximumSwap(int num) {
        
        char[] intAsCharsArr = String.valueOf(num).toCharArray();
        
        int pointerOne = 0;
        boolean swapped = false;
        
        while(pointerOne < intAsCharsArr.length && !swapped) {
            
            int pointerOneValue = intAsCharsArr[pointerOne] - '0';
            int maxValue = pointerOneValue;
            int maxIndex = pointerOne;
            
            for(int i = pointerOne; i < intAsCharsArr.length; i++) {
                
                int pointerTwoValue = intAsCharsArr[i] - '0';
                
                if(pointerTwoValue >= maxValue) {
                    maxValue = pointerTwoValue;
                    maxIndex = i;
                }
                
            }
            
            if(maxValue > pointerOneValue) {
                char temp = intAsCharsArr[pointerOne];
                intAsCharsArr[pointerOne] = intAsCharsArr[maxIndex];
                intAsCharsArr[maxIndex] = temp;
                swapped = true;
            }
            
            pointerOne++;
        }
        
        return Integer.valueOf(String.valueOf(intAsCharsArr));
    }
}