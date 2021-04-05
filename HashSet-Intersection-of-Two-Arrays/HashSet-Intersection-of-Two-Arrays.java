import scala.collection.mutable.HashSet

object Solution {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        
        val duplicateHashSet = HashSet() ++ nums1;
        
        val secondaryHashSet: HashSet[Int] = HashSet();
        
        nums2.foreach(x => {
            if(duplicateHashSet(x)) {
                secondaryHashSet += x;
            }
        });
        
        secondaryHashSet.toArray
        
    }
}