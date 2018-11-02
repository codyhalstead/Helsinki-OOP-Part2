/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Cody
 */
public class BulkTank {
    private double capacity;
    private double volume = 0;
    
    public BulkTank(){
        this.capacity = 2000;
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;
    }
    
    public double getCapacity(){
        return this.capacity;
    }
    
    public double getVolume(){
        return this.volume;
    }
    
    public double howMuchFreeSpace(){
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount){
        volume += amount;
        if(volume > capacity){
            volume = capacity;
        }
    }
    
    public double getFromTank(double amount){
        if(this.volume >= amount){
            this.volume -= amount;
            return amount;
        }
        amount = this.volume;
        this.volume = 0;
        return amount;
    }
    
    @Override
    public String toString(){
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
