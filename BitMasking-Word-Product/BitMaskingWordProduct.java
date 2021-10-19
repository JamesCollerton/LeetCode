class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        
        // Here we create a map of integers representing bit masks
        // to the maximum length of a word with that bit mask.
        Map<Integer, Integer> maskToMaxLengthMap = new HashMap<>();

        // Populating the map
        for(int i = 0; i < words.length; i++){
            
            // This is the same as saying the mask is just a string of 
            // zeros
            Integer mask = 0;

            // For each character we find what letter of the alphabet it
            // is (c - 'a'), then we shift our one along that number of 
            // places. By using |= we are leaving any bits that are already
            // in their place set, but also setting our new bit.
            for(char c: words[i].toCharArray()){
                mask |= 1 << (c - 'a');
            }
            
            // If the map already contains this mask then just put the
            // longest string value in, we don't care about shorter ones.
            if(maskToMaxLengthMap.containsKey(mask)) {
                if(maskToMaxLengthMap.get(mask) < words[i].length()) {
                    maskToMaxLengthMap.put(mask, words[i].length());
                }
            } else {
                maskToMaxLengthMap.put(mask, words[i].length());
            }
        }
        
        // Iterate through all of the masks and compare
        List<Integer> masks = maskToMaxLengthMap.keySet().stream().collect(Collectors.toList());
        
        for(int i = 0; i < masks.size(); i++) {
            for(int j = 0; j < masks.size(); j++) {
                
                int maskOne = masks.get(i);
                int maskTwo = masks.get(j);
                
                // If the bitwise AND is zero, then we know they have no common
                // bits. We then just compare the product of the two masks' max string
                // lengths to find a result.
                if((maskOne & maskTwo) == 0 &&
                   maskToMaxLengthMap.get(maskOne) * maskToMaxLengthMap.get(maskTwo) > max) {
                    max = maskToMaxLengthMap.get(maskOne) * maskToMaxLengthMap.get(maskTwo);
                }
            }
        }
        
        return max;
        
    }
}