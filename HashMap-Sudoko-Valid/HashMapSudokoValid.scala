import scala.collection.immutable.HashSet

object Solution {
        
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        
        // Sum up rows
        val rowsValid = !board.exists(row => !validSodukoLine(row, HashSet[Char]()))
        
        // Sum up columns
        val colsValid = !(0 to 8).map(i => board.map(row => row(i)))
                            .exists(col => !validSodukoLine(col, HashSet[Char]()))
        
        // Sum up squares
        val groups = List(List.range(0, 3), List.range(3, 6), List.range(6, 9))
        
        val allGroupCombinations = groups.flatMap(groupA => groups.map(groupB => (groupA, groupB)))
                
        val boardValues = allGroupCombinations.map(tup => {
            val xCoords = tup._1
            val yCoords = tup._2
            xCoords.flatMap(x => yCoords.map(y => board(x)(y)))
        })
        
        val squaresValid = !boardValues.exists(row => !validSodukoLine(row, HashSet[Char]()))
        
        rowsValid && colsValid && squaresValid
    }
    
    def validSodukoLine(line: Seq[Char], seenCharacters: HashSet[Char]): Boolean = {
        if(line.isEmpty) {
            return true
        }
        if(line(0) == '.') {
            return validSodukoLine(line.slice(1, line.length), seenCharacters)
        }
        if(seenCharacters.contains(line(0))) {
            return false
        }
        return validSodukoLine(line.slice(1, line.length), seenCharacters + (line(0)))
    }
}