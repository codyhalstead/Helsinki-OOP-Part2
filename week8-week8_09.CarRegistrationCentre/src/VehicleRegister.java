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

public class VehicleRegister {
    private HashMap<RegistrationPlate,String> owners;
    
    public VehicleRegister(){
        this.owners=new HashMap<RegistrationPlate,String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner){
        if(this.owners.get(plate)==null){
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }
    
    public String get(RegistrationPlate plate){
        if(this.owners.get(plate)==null){
            return null;
        }
        else{
        return this.owners.get(plate);
    }
    }
    
    public boolean delete(RegistrationPlate plate){
        if (this.owners.get(plate)==null){
            return false;
        }
        this.owners.remove(plate);
        return true;
    }
    
    public void printRegistrationPlates(){
        for(RegistrationPlate i:owners.keySet()){
            System.out.println(i);
        }
    }
    
    public void printOwners(){
        ArrayList<String> nonDupOwners=new ArrayList<String>();
        for(String owner:owners.values()){
            if(!nonDupOwners.contains(owner)){
                nonDupOwners.add(owner);
            }
            
            }
        for( String i:nonDupOwners){
                System.out.println(i);
        }
    }
}
