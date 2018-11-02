/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Cody
 */
public class PhoneBook {
    private HashMap<String,PersonInfo> database;
    
    public PhoneBook(){
        this.database = new HashMap<String,PersonInfo>();
    }
    
    public void addPerson(String person){
        if(!database.containsKey(person)){
            PersonInfo x = new PersonInfo(person);
            database.put(person, x = new PersonInfo(person));
        }
    }
    
    public void addNumber(String person,String number){
        database.get(person).addNumber(number);
    }
    
    public void addAddress(String person, String Address){
        database.get(person).addAddress(Address);
    }
    
    public void removePerson(String person){
        database.remove(person);
    }
    
    public List<String> getNum(String person){
       return database.get(person).getNumbers();
    }
    

    
    public HashMap<String, PersonInfo> getAllHashMaps(){
        return database;
    }
    

}