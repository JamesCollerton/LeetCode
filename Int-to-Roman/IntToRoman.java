class Solution {
    public String intToRoman(int num) {
        
        String numberString = Integer.toString(num);
        StringBuilder resultStringBuilder = new StringBuilder();
        
        int[] numArray = new int[numberString.length()];
        
        for (int i = 0; i < numberString.length(); i++) {
            numArray[i] = numberString.charAt(i) - '0';
        }
        
        if(numArray[0] == 4) {
            resultStringBuilder.insert(0, "IV");
        } else if(numArray[0] == 9) {
            resultStringBuilder.insert(0, "IX");
        } else {
            int currentNum = numArray[0];
            StringBuilder stringBuilder = new StringBuilder();
            if(numArray[0] >= 5) {
                stringBuilder.append("V");
                currentNum -= 5;
            }
            for(int i = 0; i < currentNum; i++) {
                stringBuilder.append("I");
            }
            resultStringBuilder.append(stringBuilder.toString());
        }
        
        return resultStringBuilder.toString();
    }
}