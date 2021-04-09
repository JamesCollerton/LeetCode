import scala.collection.mutable.HashMap 

object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        makeStringCharCountArr(s) == makeStringCharCountArr(t)
    }
    
    def makeStringCharCountArr(s: String): Set[List[Int]] = {
        val stringCharList = s.zipWithIndex.foldLeft(HashMap[Char, List[Int]]())((map, c) => {
            
            val currentChar = c._1
            val currentIndex = c._2
            
            if(!map.contains(currentChar)) {
                map + (currentChar -> List(currentIndex))
            } else {
                map + (currentChar -> (map(currentChar) :+ currentIndex))
            }
        })
        stringCharList.values.toSet
    }
}