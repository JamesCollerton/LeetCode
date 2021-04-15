// Make a map of number to list of indexes

// Indexes will always increase, can we use this?
// Thinking of i - j = k
//      Once we are k ahead of i we don't need to look at j
//      

object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        nums.zipWithIndex.foldLeft(false)((outerBool, c) => {
            val currNum = c._1
            val currIndex = c._2
            outerBool || List.range(1, k + 1).foldLeft(false)((innerBool, i) => {
                innerBool || (
                    (currIndex + i < nums.length) && 
                    (nums(currIndex) == nums(currIndex + i))
                )
            })
        })    
    }
}