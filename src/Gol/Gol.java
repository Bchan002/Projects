package Gol;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Gol{


    public static void main(String[] args) throws IOException,FileNotFoundException {
        


        

            ArrayList<String> list = new ArrayList<>();

           
            //Read the file
            String fileName = args[0];
            ReadFile rf = new ReadFile(fileName);
            rf.read();
            int row = rf.getRow();
            int col = rf.getCol();
            int offSetX= rf.getOffSetX();
            int offSetY = rf.getOffSetY();
            list = rf.getList();
            

            GoLBoard gol = new GoLBoard();
            gol.initiateBoard(row, col);
            gol.printInitialBoard();
            System.out.println();
            gol.populateBoard(offSetX, offSetY, list);
            gol.printInitialBoard();
            System.out.println();
            gol.nextGeneration();
            gol.printNextGenBoard();




    

         
        
    
       

    }
}