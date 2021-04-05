import scala.collection.mutable.HashSet

object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        
        if(nums.length != 1) {
            
            val remainingHashSet = HashSet() ++ nums;
            
            val seenHashSet = HashSet(nums(0));
            
            val remainingNums = nums.slice(1, nums.length);

            remainingNums.map(x => {
                val seenValue = seenHashSet(x);
                seenHashSet += x
                if (seenValue) remainingHashSet -= x
            })
            
            remainingHashSet.head
            
        } else {
            nums(0)
        }
        
    }
}