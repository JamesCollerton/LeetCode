import scala.collection.immutable.HashMap

object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        strs.foldLeft(HashMap[String, List[String]]())((hashMap, str) => {
            hashMap.get(str.sorted)
                .map(strList => {
                    hashMap + (str.sorted -> (strList :+ str))
                })
                .getOrElse(hashMap + (str.sorted -> List(str)))
        }).values.toList
    }
}