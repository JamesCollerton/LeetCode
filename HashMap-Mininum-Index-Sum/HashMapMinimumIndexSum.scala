import scala.collection.mutable.HashMap 

object Solution {
    def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
        
        val map1 = list1.zipWithIndex.foldLeft(HashMap[String, Int]())((map, c) => {
            val restaurant = c._1
            val index = c._2
            map + (restaurant -> index)
        })
            
        val startingResult = CurrentResult(list1.length + list2.length, List[String]())
        
        val endResult = list2.zipWithIndex.foldLeft(startingResult)((currRes, c) => {
    
            val restaurant = c._1
            val index = c._2
            
            map1.get(restaurant)
                .map(list1Index => index + list1Index)
                .map(indexSum => {
                    if(indexSum == currRes.lowestIndex) {
                        CurrentResult(indexSum, currRes.resultList :+ restaurant)
                    } else if(indexSum < currRes.lowestIndex) {
                        CurrentResult(indexSum, List(restaurant))
                    } else {
                        currRes
                    }
                })
                .getOrElse(currRes)

        })
                                                                    
        endResult.resultList.toArray
    }
    
    case class CurrentResult(lowestIndex: Int, resultList: List[String])
}