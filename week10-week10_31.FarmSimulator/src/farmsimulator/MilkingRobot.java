/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.io.*;
/**
 *
 * @author Cody
 */
public class MilkingRobot {
    private BulkTank tank; 
    
    public MilkingRobot(){
        this.tank = null;
    }
    
    public BulkTank getBulkTank(){
        return tank;
    }
    
    public void setBulkTank(BulkTank bulkTank){
        this.tank = bulkTank;
    }
    
    public void milk(Milkable milkable){
        double milk = milkable.milk();
        try{
            tank.addToTank(milk);
        }
        catch(Exception e){
            throw new IllegalStateException(" The MilkingRobot hasn't been installed");
        }
    }
}
