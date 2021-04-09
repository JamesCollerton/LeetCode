import scala.collection.immutable.List 

object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        makeStringCharCountArr(s) == makeStringCharCountArr(t)
    }
    
    def makeStringCharCountArr(s: String): List[Int] = {
        val stringCharList = s.foldLeft(List[(Char,Int)]())((arr, value) => {
            if(arr.length == 0) {
                arr :+ (value, 1)
            } else if(arr.last._1 == value) {
                val lastCount = arr.last
                val toAddArr = arr.dropRight(1)
                toAddArr :+ (value, lastCount._2 + 1)
            } else {
                arr :+ (value, 1)
            }
        })
        stringCharList.map(_._2)
    }
}