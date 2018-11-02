/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;
import java.util.*;

/**
 *
 * @author Cody
 */
public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> inventory;
    
    public Box(int maximumCapacity){
        this.maximumCapacity=maximumCapacity;
        this.inventory=new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing){
        if(thing.getVolume()+ this.getVolume() <= maximumCapacity){
            inventory.add(thing);
            return true;
        }
        else{
           
            return false;
        }
    }

    @Override
    public int getVolume() {
        int x=0;
        for(Thing i:inventory){
            x+=i.getVolume();//To change body of generated methods, choose Tools | Templates.
    }
        return x;
}
}
