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

public class Box implements ToBeStored {
    private double weightLimit;
    private ArrayList<ToBeStored> things; 
    
    public Box(double limit){
        this.weightLimit=limit;
        this.things=new ArrayList<ToBeStored>();
    }
    
     public void add(ToBeStored thing) {
        double weightAfterAddition = this.weight() + thing.weight();
        if (!(weightAfterAddition > this.weightLimit))
            this.things.add(thing);
    }
    
    @Override
    public double weight() {
        double weight=0;
        if (things == null) {
            return 0;
        }
        for (ToBeStored thing : things) {
            weight += thing.weight();
        }
        return weight;
    }
    
    @Override
    public String toString(){
        return "Box: "+this.things.size()+" things, total weight "+this.weight()+" kg";
    }
}
