/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String name, Barn barn){
        this.owner = name;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public void manageCows(){
        this.barn.takeCareOf(cows);
    }
    
    public void addCow(Cow cow){
        cows.add(cow);
    }
    
    public String getOwner(){
        return owner;
    }

    @Override
    public void liveHour() {
        for(Cow i : cows){
            i.liveHour();
        }
    }
    
    @Override
    public String toString(){
        return "Farm owner: " + this.owner + "\nBarn bulk tank: " + this.barn.getBulkTank() + "\n" + cowString(this.cows);
    }
    
    public String cowString(List<Cow> cows){
        if (cows.isEmpty()){
            return "No cows.";
        }
        String string = "Animals:\n";
        for (Cow i : cows){
            string += "        " + i.toString() + "\n";
        }
        return string;
    }
    
    public void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }
}
