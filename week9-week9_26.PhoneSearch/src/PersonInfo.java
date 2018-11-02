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
public class PersonInfo {
    private List<String> numbers;
    private List<String> addresses;
    private String name;
    
    public PersonInfo(String name){
        this.numbers = new ArrayList<String>();
        this.addresses = new ArrayList<String>();
        this.name=name;
        
    }
    
    public void addNumber(String number){
        numbers.add(number);
    }
    
    public void addAddress(String Address){
        addresses.add(Address);
    }
    
    public void printNumbers(){
        if(numbers.isEmpty()){
            System.out.println(" phone number not found");
        }
        else{
            System.out.println(" phone numbers");
        }
        for(String i : numbers){
            System.out.println("  "+i);
        }
    }
    
    public void printAddresses(){
        if(addresses.isEmpty()){
            System.out.println(" address unknown");
        }
        for(String i : addresses){
            System.out.println(" address: "+i);
        }
    }
    
    public List<String> getNumbers(){
        return this.numbers;
    }
    
    public List<String> getAddresses(){
        return this.addresses;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean containNumber(String search){
        for(String i : numbers){
            if(i.contains(search)){
                return true;
            }
        }
        return false;
    }
    
    public boolean containAddress(String search){
        for(String i : addresses){
            if(i.contains(search)){
                return true;
            }
        }
        return false;
    }  
        
}
