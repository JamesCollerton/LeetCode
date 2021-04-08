import scala.collection.mutable.HashMap

object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        makeStringCharCountArr(s) == makeStringCharCountArr(t)
    }
    
    def makeStringCharCountArr(s: String): Set[Int] = {
        val stringCharMap = s.foldLeft(Map.empty[Char,Int])((map, value) => {
            if(!map.contains(value)){
                map + (value -> 1)
            } else {
                map + (value -> (map(value) + 1))
            }
        })
        println(stringCharMap.values.toSet)
        stringCharMap.values.toSet
    }
}