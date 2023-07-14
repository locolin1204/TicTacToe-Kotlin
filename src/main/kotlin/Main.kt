fun main(){

    var gameBoard = GameBoard()
    var player1 = Player(1, "O")
    var player2 = Player(2, "X")
    var curPlayer = player1

    gameBoard.printBoard(player1, player2)

    while(true){
        val input = gameBoard.getPlayerInput(curPlayer)

        gameBoard.placeInputToBoard(curPlayer, input)
        gameBoard.printBoard(player1, player2)

        if (gameBoard.checkIfWin(curPlayer)) {
            println("Congratulations! Player ${curPlayer.playerNum} has won!")
            break
        }
        if (gameBoard.checkIfDraw()) {
            println("Game is draw!")
            break
        }

        curPlayer = if (curPlayer == player1) player2 else player1
    }
}