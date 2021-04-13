import scala.collection.immutable.HashMap

object Solution {
    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        val nums1HashMap = nums1.foldLeft(HashMap[Int, ArrayCounter]())((hashMap, num) => {
            hashMap.get(num).map(arrayCounter => {
                hashMap + (num -> ArrayCounter(arrayCounter.nums1Count + 1, 0))
            }).getOrElse(hashMap + (num -> ArrayCounter(1, 0)))
        })
        
        val nums2HashMap = nums2.foldLeft(nums1HashMap)((hashMap, num) => {
            hashMap.get(num).map(arrayCounter => {
                hashMap + (num -> ArrayCounter(arrayCounter.nums1Count, arrayCounter.nums2Count + 1))
            }).getOrElse(hashMap + (num -> ArrayCounter(0, 1)))
        })
        
        nums2HashMap.foldLeft(Array[Int]())({ case (arr, (num, arrayCounter)) => {
            val repeat = arrayCounter.nums1Count.min(arrayCounter.nums2Count)
            arr ++ Array.fill(repeat)(num)
        }})
    }
    
    case class ArrayCounter(nums1Count: Int, nums2Count: Int)
}