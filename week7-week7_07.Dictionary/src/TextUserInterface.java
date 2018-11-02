/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
import java.util.*;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader=reader;
        this.dictionary=dictionary;
    }
    
    public void start(){
        System.out.print("Statements:\n"+"add - adds a word pair to the dictionary\n"+"translate - asks a word and prints its translation\n"+"quit - quits the text user interface\n\n");
        askUser();
    }
    
    public void askUser(){
        while(true){
            System.out.print("Statement: ");
            String userImput=stringCleaner(reader.nextLine());
            if(userImput.equals("quit")){
                System.out.println("Cheers!");
                break;
            }
            else if(userImput.equals("add")){
                add();
                System.out.println("");
            }
            else if(userImput.equals("translate")){
                translate();
                System.out.println("");
            }
            else{
                System.out.println("Unknown statement\n");
            }
        }
    }
    
    private String stringCleaner(String string){
        if(string == null){
            return "";
        }
        string=string.toLowerCase();
        return string.trim();
    }
    
    public void add(){
        System.out.print("In Finnish: ");
        String finnish=reader.nextLine();
        System.out.print("Translation: ");
        String trans=reader.nextLine();
        dictionary.add(finnish,trans);
    }
    
    public void translate(){
        System.out.print("Give a word: ");
        String trans=dictionary.translate(reader.nextLine());
        if(trans==null){
            System.out.println("Unknown word!");
        }
        else{
        System.out.println("Translation: "+trans);
        }
    }
}
