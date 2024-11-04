package Mastermind;

import java.util.*; 

public class Mastermind {
    
    public static void main(String[] args) {
        
        //1. CodeMaker: Generate random 4 numbers from 1 to 6 for 
        Codemaker cm = new Codemaker();
        int[] codeMaker = cm.codeMaker();
        // for(int i =0; i<codeMaker.length;i++){
        //     System.out.print(codeMaker[i]);
        // }

        //2. Codebreaker: Ask user to input numbers from 1 to 6 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter 4 numbers from 1 to 6 to guess");
        String input = scanner.nextLine();
        String[] guessCode= input.trim().split("");
        int[] codeBreaker = new int[4];
        for(int i =0; i<guessCode.length;i++){
            codeBreaker[i] =  Integer.parseInt(guessCode[i]);
        }

        //Create a new array for the correct guessCode 
        int[] correctGuessCode = new int[4];

        FeedBackBoard fb = new FeedBackBoard();
        fb.printInitialFeedBackBoard();
        System.out.println();
 
        fb.checkGuess(codeMaker, codeBreaker);
        fb.populateBoard();
        fb.printBoard();


    }
}
