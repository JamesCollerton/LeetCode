class Solution {
    public String largestNumber(int[] nums) {
        
        if(nums == null || nums.length == 0) {
		    return "";
        }
		
		String[] stringArr = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
		    stringArr[i] = String.valueOf(nums[i]);
        }
					
		Arrays.sort(stringArr, (a, b) -> (b + a).compareTo(a + b));
        
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if(stringArr[0].charAt(0) == '0') {
			return "0";
        }
            
		StringBuilder sb = new StringBuilder();
		for(String s: stringArr) {
	        sb.append(s);
        }
		
		return sb.toString();    
    }
    
    
}