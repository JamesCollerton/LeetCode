import scala.collection.immutable.HashSet

object Solution {
    
    // val groupOne = (0 to 2)
    // val groupTwo = (3 to 5)
    // val groupThree = (6 to 8)
    
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        
        // Sum up rows
        val rowsValid = board.exists(row => !validSodukoLine(row, HashSet[Char]()))
        
        println(rowsValid)
        
        // Sum up columns
        val colsValid = (0 to 8).map(i => board.map(row => row(i)))
                            .exists(col => !validSodukoLine(col, HashSet[Char]()))
        
        println(rowsValid)
        
        // Sum up squares
        
        // We want all possible combinations of these three groups. These will give us the
        // all the possible coordinates. We could use a tuple for ((x1, x2, x3), (y1, y2, y3))
        // then 
        
        // (g1, g2, g3)
        
        
        val groupOne = List.range(0, 3)
        val groupTwo = List.range(3, 6)
        val groupThree = List.range(6, 9)
        val groups = List(groupOne, groupTwo, groupThree)
        
        val allGroupCombinations = groups.flatMap(groupA => groups.map(groupB => (groupA, groupB)))
        
        println(allGroupCombinations)
        
        val boardValues = allGroupCombinations.map(tup => {
            val xCoords = tup._1
            val yCoords = tup._2
            xCoords.flatMap(x => yCoords.map(y => board(x)(y)))
        })
        
        println(boardValues)
        
        val squaresValid = boardValues.exists(row => !validSodukoLine(row, HashSet[Char]()))
        
        println(squaresValid)
        
        false
    }
    
    def validSodukoLine(line: Seq[Char], seenCharacters: HashSet[Char]): Boolean = {
        if(line.isEmpty) {
            return true
        }
        if(line(0) == '.') {
            validSodukoLine(line.slice(1, line.length), seenCharacters)
        }
        if(seenCharacters.contains(line(0))) {
            return false
        }
        validSodukoLine(line.slice(1, line.length), seenCharacters + (line(0)))
    }
}