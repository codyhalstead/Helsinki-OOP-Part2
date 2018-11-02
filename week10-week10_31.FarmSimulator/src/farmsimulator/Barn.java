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
public class Barn {
    private BulkTank tank;
    private MilkingRobot bot = null;
    
    public Barn(BulkTank tank){
        this.tank = tank;
    }
    
    public BulkTank getBulkTank(){
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot bot){
        bot.setBulkTank(tank);
        this.bot = bot;
    }
    
    public void takeCareOf(Cow cow){
        if (bot == null){
            throw new IllegalStateException("MilkingRobot not installed");
        }
        bot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows){
        if (bot == null){
            throw new IllegalStateException("MilkingRobot not installed");
        }
        for (Cow i : cows){
            bot.milk(i);
        }
    }
    
    @Override
    public String toString(){
        return tank.toString();
    }
}
