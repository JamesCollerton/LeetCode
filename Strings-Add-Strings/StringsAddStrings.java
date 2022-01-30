class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        
        reverseArray(arr1);
        reverseArray(arr2);
        
        int maxLength = Math.max(arr1.length, arr2.length);
        
        StringBuilder stringBuilder = new StringBuilder();
        
        int carryOver = 0;
        
        for(int i = 0; i < maxLength; i++) {
            int val1 = i < arr1.length ? arr1[i] - '0' : 0;
            int val2 = i < arr2.length ? arr2[i] - '0' : 0;
            int sum = val1 + val2 + carryOver;
            if(sum > 9) {
                carryOver = 1;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }
            stringBuilder.append(sum);
        }
        
        if(carryOver != 0) {
            stringBuilder.append(carryOver);
        }
        
        return stringBuilder.reverse().toString();
    }
    
    private void reverseArray(char[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}