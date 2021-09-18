class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else {
            String result = "1";
            for(int i = 1; i < n; i++) {
                result = createResult(result);
            }
            return result;
        }
    }
    
    private String createResult(String n) {
        char[] arr = n.toCharArray();
        int p = 0;
        String result = "";
        while(p < arr.length) {
            char c = arr[p];
            int count = 0;
            while(p < arr.length && arr[p] == c) {
                count++;
                p++;
            }
            result += count + Character.toString(c);
        }
        return result;
    }
}