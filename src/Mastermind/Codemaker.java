package Mastermind;

import java.util.*; 

public class Codemaker {
    


    public int[] codeMaker(){

        int[] array = new int[4];
        array[0] = generateRandom();
        array[1] = generateRandom();
        array[2] = generateRandom();
        array[3] = generateRandom();

        // for(int i =0; i<array.length; i++){
        //     System.out.print(array[i]);
        // }

         return array;

    }

    public int generateRandom(){
        Random random = new Random();
        //Generate numbers from 1 to 6; 
        int rand = random.nextInt(6) + 1;
        return rand;
    }
}
