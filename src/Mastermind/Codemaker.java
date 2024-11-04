package Mastermind;

import java.util.*; 

public class Codemaker {
    

    //Must geenrate 4 unique random number
    //Try put in set thn take out 

    Set<Integer> unique = new HashSet<>();


    public int[] codeMaker(){

        int[] array = new int[4];
        while(unique.size()<4){
            unique.add(generateRandom());
        }

        //Convert Set to list
        List<Integer> listUnique = new ArrayList<>(unique);

        for(int i=0; i<listUnique.size();i++){
            array[i] = listUnique.get(i);
        }

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
