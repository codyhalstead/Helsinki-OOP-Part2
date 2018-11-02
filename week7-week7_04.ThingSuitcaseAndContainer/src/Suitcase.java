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

public class Suitcase {
    private int weightLimit;
    private ArrayList<Thing> things;
    private int weightUsed;
    
    public Suitcase(int weightLimit){
        this.weightLimit=weightLimit;
        this.things=new ArrayList<Thing>();
        this.weightUsed=0;
    }
    
    public void addThing(Thing thing){
        weightUsed+=thing.getWeight();
        if(weightUsed<=weightLimit){
            things.add(thing);
        }
        else{
            weightUsed-=thing.getWeight();
        }
    }
    
    @Override
    public String toString(){
        int amount=0;
        String plural=" things";
        for(Thing i:things){
            amount++;
        }
        if(amount==1){
        plural=" thing";
        }
        if(amount==0){
            return "empty (0kg)";
        }
        return amount+ plural+" ("+weightUsed+" kg)";
        
    }
    
    public int totalWeight(){
        return weightUsed;
    }
    
    public void printThings(){
        for(Thing i:things){
            System.out.println(i);
        }
    }
    
    public Thing heaviestThing(){
        Thing heaviest=null;
        if(!things.isEmpty()){
            heaviest=things.get(0);
            for(Thing i:things){
                if (i.getWeight()>heaviest.getWeight()){
                    heaviest=i;
                }
            }
        }
        return heaviest;
    }
}
