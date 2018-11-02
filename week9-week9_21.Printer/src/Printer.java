/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author Cody
 */
public class Printer {
    private String fileName;
    
    public Printer(String fileName) throws Exception{
        this.fileName=fileName;
    }
    
    public void printLinesWhichContain(String search) throws Exception{
        File file = new File(fileName);
        
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            if (line.contains(search)){
                System.out.println(line);
            }
        }
    }
    
}
