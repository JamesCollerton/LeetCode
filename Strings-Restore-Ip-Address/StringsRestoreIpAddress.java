class Solution {
    
    private List<String> result = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        
        int[] arr = new int[s.length()];
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i < charArr.length; i++) {
            arr[i] = charArr[i] - '0';
        }
        
        recurse(arr, 0, 3, "");
        
        return result;
    }
    
    private void recurse(int[] arr, int pointer, int remainingBreaks, String ipAddress) {
        // We've run out of points we can put in the string, check the rest of the array
        // and make sure that the 
        if(remainingBreaks == 0) {
            // If we're on the last or second last numbers then add them
            if(pointer == arr.length - 1) {
                result.add(ipAddress + arr[pointer]);
            } else if(pointer == arr.length - 2 && arr[pointer] != 0) {
                result.add(ipAddress + arr[pointer] + arr[pointer + 1]);
            } else if(pointer == arr.length - 3 && arr[pointer] != 0) {
                if(arr[pointer] * 100 + arr[pointer + 1] * 10 + arr[pointer + 2] < 256) {
                    result.add(ipAddress + arr[pointer] + arr[pointer + 1] + arr[pointer + 2]);    
                }
            }
        }
        
        // Need to check pointer hasn't moved off
        if(pointer >= arr.length) {
            return;
        }
        
        // If we're currently on a zero then we need to put a '.' after
        if(arr[pointer] == 0) {
            recurse(arr, pointer + 1, remainingBreaks - 1, ipAddress + "0.");
        } else {
            // You can always move one or two places as these will be less
            // than 255
            recurse(arr, pointer + 1, remainingBreaks - 1, ipAddress + arr[pointer] + ".");
            
            if(pointer + 1 < arr.length) {
                recurse(arr, pointer + 2, remainingBreaks - 1, ipAddress + arr[pointer] + arr[pointer + 1] + ".");
            }
            
            if( pointer + 1 < arr.length && 
                pointer + 2 < arr.length && 
                arr[pointer] * 100 + arr[pointer + 1] * 10 + arr[pointer + 2] < 256) {
                recurse(
                    arr, 
                    pointer + 3, 
                    remainingBreaks - 1, 
                    ipAddress + arr[pointer] + arr[pointer + 1] + arr[pointer + 2] + "."
                );
            }
        }
        
    }
    
}