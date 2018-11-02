/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;
import java.util.*;
/**
 *
 * @author Cody
 */
public class MaxWeightBox extends Box{
    private int maxWeight;
    private List<Thing> thingsInBox = new ArrayList<Thing>();
    
    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
    }
    
    @Override
    public void add(Thing thing) {
        int usedWeight = 0;
        for (Thing i : thingsInBox){
            usedWeight += i.getWeight();
        }
        if (thing.getWeight() +  usedWeight <= this.maxWeight){
            usedWeight += thing.getWeight();
            this.thingsInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (thingsInBox.contains(thing)){
            return true;
        }
        return false;
    }
    
}
