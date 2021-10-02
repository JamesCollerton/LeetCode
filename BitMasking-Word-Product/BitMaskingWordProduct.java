class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        
        Map<Integer, Integer> maskToMaxLengthMap = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            
            Integer mask = 0;
            for(char c: words[i].toCharArray()){
                mask |= 1 << (c - 'a');
            }
            
            if(maskToMaxLengthMap.containsKey(mask)) {
                if(maskToMaxLengthMap.get(mask) < words[i].length()) {
                    maskToMaxLengthMap.put(mask, words[i].length());
                }
            } else {
                maskToMaxLengthMap.put(mask, words[i].length());
            }
        }
        
        List<Integer> masks = maskToMaxLengthMap.keySet().stream().collect(Collectors.toList());
        
        for(int i = 0; i < masks.size(); i++) {
            for(int j = 0; j < masks.size(); j++) {
                
                int maskOne = masks.get(i);
                int maskTwo = masks.get(j);
                
                if((maskOne & maskTwo) == 0 &&
                   maskToMaxLengthMap.get(maskOne) * maskToMaxLengthMap.get(maskTwo) > max) {
                    max = maskToMaxLengthMap.get(maskOne) * maskToMaxLengthMap.get(maskTwo);
                }
            }
        }
        
        return max;
        
    }
}