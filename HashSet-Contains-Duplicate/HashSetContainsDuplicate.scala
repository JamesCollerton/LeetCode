import scala.collection.mutable.HashSet

object Solution {
    
    def containsDuplicate(nums: Array[Int]): Boolean = {
        
        if(nums.length != 1) {
        
            // Initialise hashset with first number
            val seenHashSet = HashSet(nums(0));
            
            val remainingNums = nums.slice(1, nums.length);

            remainingNums.map(x => {
                val seenValue = seenHashSet(x);
                seenHashSet += x
                seenValue
            }).exists((x: Boolean) => x == true)
            
        } else {
        
            false;
            
        }
    }
}