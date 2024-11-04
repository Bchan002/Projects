package Mastermind;

import java.util.*;

public class FeedBackBoard {
    // Create a 2D array
    private String[][] colorTag = new String[2][2];
    
    //Create a list to store the colors 
    private List<String> colorsList = new ArrayList<>();

    public void printInitialFeedBackBoard() {

        // Populate the 2D array with black color - means nothing
        // Red - correct number, correct placing
        // white - correct number, wrong placing
        for (int l = 0; l < colorTag.length; l++) {
            for (int m = 0; m < colorTag[0].length; m++) {
                colorTag[l][m] = "null";
            }
        }

        for (int n = 0; n < colorTag.length; n++) {
            for (int o = 0; o < colorTag[0].length; o++) {
                System.out.print(colorTag[n][o] + " ");
            }
            System.out.println();
        }
    }

    public void checkGuess(int[] codeMaker, int[] codeBreaker) {

        for(int i =0; i< codeMaker.length;i++){
            for(int j=0; j<codeBreaker.length; j++){
                if(codeBreaker[j] == codeMaker[i] && i==j){
                    colorsList.add("red");
                } else if(codeBreaker[j]==codeMaker[i] && i!=j){
                    colorsList.add("white");
                }
            }
        }

    }

    public void populateBoard(){
        try{
            //Create a counter to increase k by 1 to get the colorList
            int k =0;
            for(int i =0; i<colorsList.size();i++){
                for(int j=0; j<colorTag.length;j++){
                    colorTag[i][j] = colorsList.get(k);
                    k++;
                }
            }

        } catch(IndexOutOfBoundsException ex){

        }
    }

    public void printBoard(){
        for (int i = 0; i < colorTag.length; i++) {
            for (int j = 0; j < colorTag[0].length; j++) {
                System.out.print(colorTag[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkBoard(){

        Boolean hasWon = false;

        for (int i = 0; i < colorTag.length; i++) {
            for (int j = 0; j < colorTag[0].length; j++) {
                if(colorTag[i][j].equals("red")){
                    hasWon = true;
                    break;
                } else{
                    hasWon = false;
                }
            }
        }

        if(hasWon){
            System.out.println("Ypu have won!");
        } else{
            System.out.println("Please try again");
        }
        
    }

     
}
