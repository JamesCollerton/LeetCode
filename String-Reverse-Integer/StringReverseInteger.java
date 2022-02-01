class Solution {
    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        if(x < 0) {
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.reverse();
        while(stringBuilder.length() != 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        String result = stringBuilder.toString();
        if(tooLarge(result)) {
            return 0;
        }
        if(!stringBuilder.isEmpty() && x < 0) {
            result = "-" + result;
        }
        return Integer.valueOf(result);
    }
    
    private boolean tooLarge(String s) {
        System.out.println(s);
        if(s.length() >= 10) {
            int[] numArray = new int[]{2,1,4,7,4,8,3,6,4,7};
            for(int i = 0; i < numArray.length; i++) {
                int digit = s.charAt(i) - '0';
                if(digit > numArray[i]) {
                    return true;
                }
                if(digit < numArray[i]) {
                    return false;
                }
            }
        }
        return false;
    }
}