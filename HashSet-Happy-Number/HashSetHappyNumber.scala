import scala.collection.mutable.HashSet

object Solution {
    def isHappy(n: Int): Boolean = {
        
        val seenSolutions: HashSet[Int] = HashSet()
        
        isHappyStep(seenSolutions, n)
           
    }
    
    def isHappyStep(seenSolutions: HashSet[Int], n: Int): Boolean = {
        
        if(n == 1) {
            return true
        }
        
        seenSolutions += n
        
        val newSquare = n.toString.map(_.asDigit).toArray.map((x:Int) => x*x).reduce((x, y) => x + y)
        
        n.toString.map(_.asDigit).toArray.foreach(println)
        println(newSquare)
        println()
        
        val isSeen = seenSolutions(newSquare)
        
        if(isSeen) {
            return false
        } else {
            return isHappyStep(seenSolutions, newSquare)
        }
        
    }
}