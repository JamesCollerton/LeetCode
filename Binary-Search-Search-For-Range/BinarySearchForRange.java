class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        int nearestIndex = findNearestIndex(arr, x);
        
        while(nearestIndex - 1 >= 0 && arr[nearestIndex - 1] == arr[nearestIndex]) {
            nearestIndex--;
        }
        
        System.out.println("Nearest index " + nearestIndex);
        
        result.add(arr[nearestIndex]);
        
        int numbersLeft = k -  1;
        int left = nearestIndex - 1;
        int right = nearestIndex + 1;
        
        while(numbersLeft > 0) {
            if(left >= 0 && right < arr.length) {
                int distanceOne = Math.abs(arr[left] - x);
                int distanceTwo = Math.abs(arr[right] - x);
                if(distanceOne <= distanceTwo) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
            numbersLeft--;
        }
        
        return result;
    }
    
    private int findNearestIndex(int[] arr, int target) {
        if(target < arr[0]) {
            return 0;
        }
        
        if(target > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            
            int mid = left + (right - left) / 2;
            
            int distanceOne = Math.abs(arr[mid] - target);
            int distanceTwo = Math.abs(arr[mid + 1] - target);
            
            if(distanceTwo <= distanceOne) {
                left = mid + 1;
            } else {
                right = mid;
            } 
        }
        
        return right;
    }
}