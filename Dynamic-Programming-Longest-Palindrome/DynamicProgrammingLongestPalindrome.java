class Solution {
    public String longestPalindrome(String s) {
        
        char[] arr = s.toCharArray();
        String result = "";
        
        for(int i = 0; i < arr.length; i++) {
            String potentialResult = checkArr(arr, i, i);
            result = potentialResult.length() > result.length() ? potentialResult : result;
            potentialResult = checkArr(arr, i, i + 1);
            result = potentialResult.length() > result.length() ? potentialResult : result;
        }
        
        return result;
    }
    
    private String checkArr(char[] arr, int left, int right) {
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while(left >= 0 && right < arr.length && arr[left] == arr[right]) {
            stringBuilder.insert(0, arr[left]);
            if(left != right) {
                stringBuilder.append(arr[right]);
            }
            left--;
            right++;
        }
        
        return stringBuilder.toString();
    }
}