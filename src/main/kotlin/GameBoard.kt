class GameBoard {
    var board: IntArray = IntArray(9)

    fun checkIfWin() {

    }

    fun checkIfDraw() {

    }

    fun getPlayerInput() {

    }

    fun printBoard() {
        println("—————————————")
        for (i in 0..2) {
            for (j in 0..2) {
                print("| ${i * 3 + j} ")
            }
            print("|\n")
            println("—————————————")
        }
    }

}