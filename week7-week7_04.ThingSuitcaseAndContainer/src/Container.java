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
        
public class Container {
    private ArrayList<Suitcase> suitcases;
    private int weightLimit;
    private int weightUsed;
    
    public Container(int weightLimit){
        this.suitcases=new ArrayList<Suitcase>();
        this.weightLimit=weightLimit;
        this.weightUsed=0;
    }
    
    public void addSuitcase(Suitcase suitcase){
        weightUsed+=suitcase.totalWeight();
        if(weightUsed<=weightLimit){
            suitcases.add(suitcase);
        }
        else{
            weightUsed-=suitcase.totalWeight();
        }
    }
    
    @Override
    public String toString(){
        int amount=0;
        String plural=" suitcases";
        for(Suitcase i:suitcases){
            amount++;
        }
        if(amount==0){
            return "empty (0 kg)";
        }
        if(amount==1){
            plural=" suitcase";
        }
        return amount+plural+" ("+weightUsed+" kg)";
    }
    
    public void printThings(){
        for(Suitcase i:suitcases)
            i.printThings();
    }
    
}
