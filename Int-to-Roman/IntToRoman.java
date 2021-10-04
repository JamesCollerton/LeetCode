class Solution {
    public String intToRoman(int num) {
        
        String numberString = new StringBuilder(Integer.toString(num)).reverse().toString();
        StringBuilder resultStringBuilder = new StringBuilder();
        
        int[] numArray = new int[numberString.length()];
        
        for (int i = 0; i < numberString.length(); i++) {
            numArray[i] = numberString.charAt(i) - '0';
        }
        
        List<RomanInfo> romanInfoList = new ArrayList<>();
        romanInfoList.add(new RomanInfo(0, "I", "X", "V"));
        romanInfoList.add(new RomanInfo(1, "X", "C", "L"));
        romanInfoList.add(new RomanInfo(2, "C", "M", "D"));
        romanInfoList.add(new RomanInfo(3, "M", "N/A", "N/A"));
        
        for(int index = 0; index < numArray.length; index++) {
        
            RomanInfo romanInfo = romanInfoList.get(index);
            
            if(numArray[index] == 4) {
                resultStringBuilder.insert(0, romanInfo.four);
            } else if(numArray[index] == 9) {
                resultStringBuilder.insert(0, romanInfo.nine);
            } else {
                int currentNum = numArray[index];
                StringBuilder stringBuilder = new StringBuilder();
                if(currentNum >= 5) {
                    System.out.println("Detected five " + index);
                    stringBuilder.append(romanInfo.five);
                    currentNum -= 5;
                }
                for(int i = 0; i < currentNum; i++) {
                    System.out.println("In loop " + index);
                    stringBuilder.append(romanInfo.unit);
                }
                resultStringBuilder.insert(0, stringBuilder.toString());
            }
            
        }
        
        return resultStringBuilder.toString();
    }
    
    private class RomanInfo {
        
        int index;
        String unit;
        String nextUnit;
        String five;
        String four;
        String nine;
        
        public RomanInfo(int index, String unit, String nextUnit, String five) {
            this.index = index;
            this.unit = unit;
            this.nextUnit = nextUnit;
            this.five = five;
            this.four = unit + five;
            this.nine = unit + nextUnit;
        }
        
    }
    
}