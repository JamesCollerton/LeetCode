object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        for(i <- 0 to nums.length) {
            if(containsNearbyDuplicateStep(nums.slice(i, nums.length), k)) {
                return true
            }
        }
        false
    }
    
    def containsNearbyDuplicateStep(nums: Array[Int], k: Int): Boolean = {
        for(i <- 1 to k) {
            if((i < nums.length) && (nums(0) == nums(i))) {
                return true
            }
        }
        false
    }
}