class GameBoard {
    private var board: Array<Int?> = arrayOfNulls(9)

    fun checkIfWin(player: Player): Boolean {
        for (i in 0..2){
            if (board[i] == board[i+1] && board[i] == board[i+2] && board[i] == player.playerNum) return true
            if (board[i] == board[i+3] && board[i] == board[i+6] && board[i] == player.playerNum) return true
        }

        if (board[0] == board[4] && board[0] == board[8] && board[0] == player.playerNum) return true
        if (board[2] == board[4] && board[2] == board[6] && board[2] == player.playerNum) return true

        return false
    }

    fun checkIfDraw(): Boolean {
        board.forEach{
            if (it == null) return false
        }
        return true
    }

    fun getPlayerInput(player: Player): Int{
        print("Player ${player.playerNum}, Input current move [ ${player.symbol} ]: ")
        var input: Int = readLine()!!.toInt()
        while (!isValidateInput(input)) {
            print("Input move again: ")
            input = readLine()!!.toInt()
        }
        return input
    }

    fun placeInputToBoard(player: Player, input: Int) {
        this.board[input] = player.playerNum
    }

    private fun isValidateInput(input: Int): Boolean{
        if (input < 0 || input > 8){
            println("Out of Range!")
            return false
        }

        board[input]?.let{
            println("It is occupied!")
            return false
        }

        return true
    }

    fun printBoard(player1: Player, player2: Player) {
        println("—————————————")
        for (i in 0..2) {
            for (j in 0..2) {
                val cell = this.board[i * 3 + j]?.let {
                    if (this.board[i * 3 + j] == player1.playerNum) player1.symbol
                    else player2.symbol
                } ?: run {
                    i * 3 + j
                }
                print("| $cell ")
            }
            print("|\n")
            println("—————————————")
        }
    }

}