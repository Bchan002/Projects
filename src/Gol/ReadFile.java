package Gol;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    private final String file;
    private ArrayList<String> list;
    private int row;
    private int col;
    private int offSetX;
    private int offSetY;

    public ReadFile(String fileName){
        this.file = fileName;
        this.list = new ArrayList<>();
    }

    public void read() {
         
        try{
             
            //Get or Create the file
            File readFile = new File(this.file);

            if(!readFile.exists()){
                System.out.println("File does not exist");
            }

            //Input stream, chracter input stream
            FileReader fr = new FileReader(readFile);
            BufferedReader br = new BufferedReader(fr);

            
            
            while(true){ 
                String content = br.readLine();

                if(content == null){
                    break;
                }

                if(content.startsWith("#")){
                    continue;

                } else if (content.startsWith("GRID")){
                    String[] grid = content.split(" ");
                    this.row = Integer.valueOf(grid[1]);
                    this.col = Integer.valueOf(grid[2]);
                    


                } else if(content.startsWith("START")){
                    String[] start = content.split(" ");
                    this.offSetX = Integer.valueOf(start[1]);
                    this.offSetY = Integer.valueOf(start[2]);

                } else if (content.startsWith("DATA")){
                     //Continue reading 
                     while(true){
                        String starShape = br.readLine();
                        if(starShape== null){
                          break;
                        } else{
                            list.add(starShape);
                        }
                    }   
                }

                 
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException f){
            System.out.println("File not found");
        } catch (IOException io){
            System.out.println("IO exception");
        }
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }


    public int getOffSetX(){
        return this.offSetX;
    }

    public int getOffSetY(){
        return this.offSetY;
    }


    public ArrayList<String> getList(){
        return this.list;
    }
     

   

}
