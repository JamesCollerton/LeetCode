class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else {
            long result = 1;
            for(int i = 1; i < n; i++) {
                result = createResult(result);
                // System.out.println(result);
            }
            return Long.toString(result);
        }
    }
    
    private long createResult(long n) {
        // System.out.println("n " + n);
        char[] arr = Long.toString(n).toCharArray();
        int p = 0;
        String result = "";
        while(p < arr.length) {
            char c = arr[p];
            int count = 0;
            while(p < arr.length && arr[p] == c) {
                count++;
                p++;
            }
            // System.out.println("Char " + c);
            // System.out.println("Count " + count);
            // System.out.println("P " + p);
            result += count + Character.toString(c);
            // p++;
        }
        return Long.parseLong(result);
    }
}