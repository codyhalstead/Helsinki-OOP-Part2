/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import java.io.*;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Analysis {
    private File file;
    
    public Analysis(File file){
        this.file=file;
    }
    
    public int lines(){
        Scanner reader = null;
        int lines = 0;
        try{
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                lines++;
                reader.nextLine();
            }
        } catch(Exception e){
            System.out.println("nope");
        }
        reader.close();
        return lines;
    }
    
    public int characters(){
        Scanner reader = null;
        int chars = 0;
        try{
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                chars += line.length()+1;
            }
        }catch(Exception e){
            System.out.println("yeah");
        }
        reader.close();
        return chars;
    }
}
