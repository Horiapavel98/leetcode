class IsValidSudoku {

    def containsDuplicates(ls: List[Char]) : Boolean = {
        return ls.filter(_ != '.').distinct.size != ls.filter(_ != '.').size
    }

    def getSurroundings(a: Int, b: Int) : List[(Int, Int)] = {
        return (for (i <- a - 1 to a + 1; j <- b - 1 to b + 1) yield (i, j)).toList
    }

    def isValidSudoku(board: Array[Array[Char]]) : Boolean = {

        // Row validation
        for (row <- board) {
            if (containsDuplicates(row.toList)) {
                println("Not unique row...")
                println(row.toList)
                return false
            }
        }

        // Column validation
        for (i <- 0 to 8) {
            if(containsDuplicates((for (j <- 0 to 8) yield board(j)(i)).toList)){
                println("Not unique column...")
                return false
            }
            
        }

        // Square validation
        // Get the surroundings for pre-defined centre points of each of the 9 squares
        val centres: List[(Int, Int)] = List((1,1), (1,4), (1, 7), (4, 1), (4, 4), (4, 7), (7, 1), (7, 4), (7, 7))
        for (centre <- centres) {
            if(containsDuplicates((for (coords <- getSurroundings(centre._1, centre._2)) yield board(coords._1)(coords._2)).toList)) {
                println("Not unique square...")
                return false
            }
        }
        return true
    }
}

object IsValidSudoku {
    
    /**
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        
    }
    */

    def main(args : Array[String]): Unit = {
        val inst: IsValidSudoku = new IsValidSudoku()
        val board: Array[Array[Char]] = Array(
            Array('5','3','.','.','7','.','.','.','.'),
            Array('6','.','.','1','9','5','.','.','.'),
            Array('.','9','8','.','.','.','.','6','.'),
            Array('8','.','.','.','6','.','.','.','3'),
            Array('4','.','.','8','.','3','.','.','1'),
            Array('7','.','.','.','2','.','.','.','6'),
            Array('.','6','.','.','.','.','2','8','.'),
            Array('.','.','.','4','1','9','.','.','5'),
            Array('.','.','.','.','8','.','.','7','9')
            )
        println(inst.isValidSudoku(board))
    }
}