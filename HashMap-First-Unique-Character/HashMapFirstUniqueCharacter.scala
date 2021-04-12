import scala.collection.immutable.HashMap

object Solution {
    def firstUniqChar(s: String): Int = {
        val hashMap = s.zipWithIndex.foldLeft(HashMap[Char, CharCounter]())((hashMap, c) => {
            val currentChar = c._1
            val index = c._2
            hashMap.get(currentChar).map(charCounter => {
                val newCharCounter = CharCounter(charCounter.count + 1, charCounter.lowestIndex)
                hashMap + (currentChar -> newCharCounter)
            }).getOrElse(hashMap + (currentChar -> CharCounter(1, index)))
        })
            
        val lowestIndex = hashMap.values.foldLeft(s.length + 1)((lowestIndex, charCounter) => {
            if(charCounter.count == 1 && charCounter.lowestIndex < lowestIndex) {
                charCounter.lowestIndex
            } else {
                lowestIndex
            }
        })
        
        if(lowestIndex == s.length + 1) {
            -1
        } else {
            lowestIndex
        }
    }
    
    case class CharCounter(count: Int, lowestIndex: Int)
}