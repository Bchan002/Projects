package TicTacToe;

import java.util.Scanner;

public class TicTacToeMain {
        static boolean player1 = true;
    static boolean player2 = true;

    public static void main(String[] args) {
        
         

        TicTacToe ttt = new TicTacToe();
        ttt.board(3, 3);
        ttt.printBoard();

        Scanner scanner = new Scanner(System.in);



        while(true){
            //Player 1 turns 
            while(true){
                System.out.println("Player 1: Enter a row number: ");
                int row = Integer.parseInt(scanner.nextLine());
                System.out.println("Player 1: Enter a column number: ");
                int col = Integer.parseInt(scanner.nextLine());

                if(!ttt.populateBoardPlayer1(row, col)){
                    break;
                } else{
                    System.out.println("Invalid move, move has been takem");
                }
            }

            String result = ttt.checkBoard();
            if(result.equals("Player 1 has won!")){
                System.out.println("Player 1 has won!!");
                ttt.printBoard();
                break;
            } else if(result.equals("draw")){
                System.out.println("draw");
                ttt.printBoard();
                break;
            }

            ttt.printBoard();

            //Player2 turns 
            // while(true){
            //     System.out.println("Player 2: Enter a row number: ");
            //     int row = Integer.parseInt(scanner.nextLine());
            //     System.out.println("Player 2: Enter a column number: ");
            //     int col = Integer.parseInt(scanner.nextLine());

            //     if(!ttt.populateBoardPlayer2(row, col)){
            //         break; //correct move
            //     } else{
            //         System.out.println("Invalid move, please enter again");
            //     }
            // }

            System.out.println();
            System.out.println("Ai's turn: ");
            ttt.aiMove();  
            String result2 = ttt.checkBoard();
            if(result2.equals("Player 2 has won!")){
                System.out.println("Player 2 has won!!");
                ttt.printBoard();
                break;
            } else if(result2.equals("draw")){
                System.out.println("draw");
                ttt.printBoard();
                break;
            }

            ttt.printBoard();


        }



    }
}
