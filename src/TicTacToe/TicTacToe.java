package TicTacToe;

public class TicTacToe {
    private static int row;
    private static int col;
    private static char[][] initialBoard;

    public static void board(int row, int col) {
        initialBoard = new char[row][col];
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[0].length; j++) {
                initialBoard[i][j] = '-';
            }
        }

    }

    public char[][] cloneBoard(char[][] board) {
        char[][] clonedBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                clonedBoard[i][j] = board[i][j];
            }
        }
        return clonedBoard;
    }

    public static Boolean populateBoardPlayer1(int row, int col) {

        // Check if the move is valid
        try {
            if (row < 0 || row >= initialBoard.length || col < 0 || col >= initialBoard[0].length) {
                System.out.println("Please enter  a valid move again ");
            }
        } catch (Exception i) {
            i.printStackTrace();
        }

        Boolean hasEmpty = hasMovesAvailable(initialBoard);
        Boolean playerHasMove = false;

        if(hasEmpty && initialBoard[row][col]!='O'){
            initialBoard[row][col] = 'X';
        } else{
            playerHasMove = true;
        }

        return playerHasMove;

    }

    // public static Boolean populateBoardPlayer2(int row, int col) {
    //     // Check if the move is valid
    //     try {
    //         if (row < 0 || row >= initialBoard.length || col < 0 || col >= initialBoard[0].length) {
    //             System.out.println("Please enter  a valid move again ");
    //         }
    //     } catch (Exception i) {
    //         i.printStackTrace();
    //     }

    //     Boolean hasMove = hasMovesAvailable(initialBoard);
    //     Boolean playerHasMove = false;
        

    //     if (hasMove && initialBoard[row][col]!='X'){
    //         initialBoard[row][col] = 'O';
           
    //     } else{
    //         playerHasMove=true;
    //     }

    //     return playerHasMove;

    // }


    public static String checkBoard() {
        
        // Check rows
        for(int i=0; i<initialBoard.length;i++){
            if(initialBoard[i][0]!='-' && initialBoard[i][0]==initialBoard[i][1] 
                && initialBoard[i][1] == initialBoard[i][2]){
                    if(initialBoard[i][0] =='X'){
                        return "Player 1 has won!";
                    } else {
                        return "Player 2 has won!";
                    }
                }
        }
        
        //Check columns 
        for(int j =0; j<initialBoard[0].length;j++){
            if(initialBoard[0][j]!= '-' && initialBoard[0][j]==initialBoard[1][j] &&
                initialBoard[1][j] == initialBoard[2][j]){
                    if(initialBoard[0][j] == 'X'){
                        return "Player 1 has won!";
                    } else{
                        return "Player 2 has won!";
                    }
            }
        }

        //Check for diagonals
        if (initialBoard[1][1] != '-') {
            if ((initialBoard[0][0] == initialBoard[1][1] && initialBoard[1][1] == initialBoard[2][2]) ||
                (initialBoard[0][2] == initialBoard[1][1] && initialBoard[1][1] == initialBoard[2][0])) {
                if (initialBoard[1][1] == 'X') {
                    return "Player 1 has won!";
                } else {
                    return "Player 2 has won!";
                }
            }
        }

        //Check for draw 

        if(!hasMovesAvailable(initialBoard)){
            return "draw";
        }

        return "Game is still ongoing";
    
    }


    //CheckBoard for the hypothesis testing 
    public static String checkBoard(char[][] board) {
        
        // Check rows
        for(int i=0; i<board.length;i++){
            if(board[i][0]!='-' && board[i][0]==board[i][1] 
                && board[i][1] == board[i][2]){
                    if(board[i][0] =='X'){
                        return "Player 1 has won!";
                    } else {
                        return "Player 2 has won!";
                    }
                }
        }
        
        //Check columns 
        for(int j =0; j<board[0].length;j++){
            if(board[0][j]!= '-' && board[0][j]==board[1][j] &&
                board[1][j] == board[2][j]){
                    if(board[0][j] == 'X'){
                        return "Player 1 has won!";
                    } else{
                        return "Player 2 has won!";
                    }
            }
        }

        //Check for diagonals
        if (board[1][1] != '-') {
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
                if (initialBoard[1][1] == 'X') {
                    return "Player 1 has won!";
                } else {
                    return "Player 2 has won!";
                }
            }
        }

        //Check for draw 

        if(!hasMovesAvailable(board)){
            return "draw";
        }

        return "Game is still ongoing";
    

    }




    public static Boolean hasMovesAvailable(char[][] initialBoard) {
        // Check if any empty squares are available on the board
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[i].length; j++) {
                if (initialBoard[i][j] == '-') {
                    return true; // There are still empty squares available on the board

                }
            }
        }

        // If there are no empty squares are found
        return false;
    }

    public static void printBoard() {
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[0].length; j++) {
                System.out.print(initialBoard[i][j]);
            }
            System.out.println();
        }

    }








    //Define the miniMax algorithm 
    public int miniMax(char[][] board, boolean isMaximizing){

        // System.out.println("evaluating board in miniMax, isMaiximising: " + isMaximizing);
        // printBoard();
        //Check whetehr anyones win or draw 
        String result = checkBoard(board);
        if(result.equals("Player 1 has won!")){
            return -1;
        }
        if(result.equals("Player 2 has won!")){
            return 1;
        }
        if(result.equals("draw")){
            return 0;
        }

        if(isMaximizing){
            //Finding the bestScore for the all the possible next turn by the AO player
            int bestScore = Integer.MIN_VALUE;
            for(int i=0; i<board.length;i++){
                for(int j=0; j<board[0].length;j++){
                    if(board[i][j] == '-'){
                        //clone the board 
                        char[][] cloneBoard = cloneBoard(board);
                        cloneBoard[i][j] = 'O';
                        int score = miniMax(cloneBoard,false); //Calls the miniMax function and now player 1 turn;
                        if(score>bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        } else{
            //Finding the bestScore for the Human player
            int bestScore = Integer.MAX_VALUE;
            for(int i=0; i<board.length;i++){
                for(int j=0; j<board[0].length;j++){
                    if(board[i][j] == '-'){
                        char[][] cloneBoard = cloneBoard(board);
                        cloneBoard[i][j] = 'X';
                        int score = miniMax(cloneBoard, true);
                        if(score<bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
       
    
    }


    public void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int moveRow = -1, moveCol = -1;
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[i].length; j++) {
                if (initialBoard[i][j] == '-') {
                    char[][] cloneBoard = cloneBoard(initialBoard);
                    cloneBoard[i][j] = 'O'; // AI's move
                    int score = miniMax(cloneBoard, false);
                    if (score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
            }
        }
    //       // Debug print: Show the best move found by the AI
    //    System.out.println("AI has chosen move at row: " + moveRow + ", col: " + moveCol + " with score: " + bestScore);
        if (moveRow != -1 && moveCol != -1) {
            initialBoard[moveRow][moveCol] = 'O'; // Make the best move
        }
    }    
}
