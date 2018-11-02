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
public class UI {
    private Scanner reader;
    private PhoneBook phoneBook;
    
    public UI(Scanner reader){
        this.reader = reader;
        this.phoneBook = new PhoneBook();
    }
    
    public void menu(){
        System.out.println("Phone search\n" +
                "available operations\n" +
                "1 add a number\n" +
                "2 search for a number\n" +
                "3 search for a person by phone number\n" +
                "4 add an address\n" +
                "5 search for personal information\n" +
                "6 delete personal information\n" +
                "7 filtered listing\n" +
                "x quit\n");
    }
    
    public void run(){
        menu();
        while(true){
            System.out.print("command: ");
            String choice = reader.nextLine();
            if(choice.equals("1")){
                addNum();
            }
            else if(choice.equals("2")){
                searchNum();
            }
            else if(choice.equals("3")){
                searchForPersonByNum();
            }
            else if(choice.equals("4")){
                addAddress();
            }
            else if(choice.equals("5")){
                searchPersonalInfo();
            }
            else if(choice.equals("6")){
                deleteInfo();
            }
            else if(choice.equals("7")){
                filteredListing();
            }
            else if(choice.equals("x")){
                break;
            }
        }    
    }
    
    public void addNum(){
        System.out.print("Whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        this.phoneBook.addPerson(name);
        this.phoneBook.addNumber(name, number);
        System.out.println("");
    }
    
    public void searchNum(){
        System.out.print("whose number: ");
        String name = reader.nextLine();
        try{
            for(String i : this.phoneBook.getNum(name)){
                System.out.println(" "+i);
            }
            System.out.println("");
        }
        catch(Exception e){
            System.out.println(" not found\n");
        }
    }
    
    public void searchForPersonByNum(){
        System.out.print("number: ");
        String number = reader.nextLine();
        String helper = "";
        for(String i :phoneBook.getAllHashMaps().keySet()){
            for(String x : phoneBook.getAllHashMaps().get(i).getNumbers()){
                if(number.equals(x)){
                    helper+=(" "+phoneBook.getAllHashMaps().get(i).getName()+"\n");   
                }
            }      
        }
        if(helper.equals("")){
            helper+=" not found\n";
        }
        System.out.println(helper);
    }
    
    public void addAddress(){
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        System.out.println("");
        this.phoneBook.addPerson(name);
        String address = street+" "+city;
        this.phoneBook.addAddress(name, address);
    }
    
    public void searchPersonalInfo(){
        System.out.print("whose information: ");
        String name = reader.nextLine();
        try{
            phoneBook.getAllHashMaps().get(name).printAddresses();
            phoneBook.getAllHashMaps().get(name).printNumbers();
        }
        catch(Exception e){
            System.out.println("  not found");
        }
        System.out.println("");
        
    }
    
    public void deleteInfo(){
        System.out.println("whose information: ");
        String name = reader.nextLine();
        phoneBook.removePerson(name);
        System.out.println("");
    }
    
    public void filteredListing(){
        System.out.print("keyword (if empty, all listed): ");
        String search = reader.nextLine();
        ArrayList<String> results = new ArrayList<String>();
        for(String i : phoneBook.getAllHashMaps().keySet()){
            if(phoneBook.getAllHashMaps().get(i).getName().contains(search)||phoneBook.getAllHashMaps().get(i).containAddress(search)||phoneBook.getAllHashMaps().get(i).containNumber(search)){
                results.add(phoneBook.getAllHashMaps().get(i).getName());
            }
        }
        if(results.isEmpty()){
            System.out.println(" keyword not found");
        }
        else{
            System.out.println("");
            Collections.sort(results);
            for(String i : results){
                    System.out.println(" "+ phoneBook.getAllHashMaps().get(i).getName());
                    System.out.print(" ");
                    phoneBook.getAllHashMaps().get(i).printAddresses();
                    System.out.print(" ");
                    phoneBook.getAllHashMaps().get(i).printNumbers();
                    System.out.println("");
            }
        }
    }
}
