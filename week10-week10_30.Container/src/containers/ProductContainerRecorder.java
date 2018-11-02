/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;
import java.util.*;
/**
 *
 * @author Cody
 */
public class ProductContainerRecorder extends ProductContainer{
    private ContainerHistory history;

    public ProductContainerRecorder(String name, double tilavuus, double initialVolume) {
        super(name, tilavuus);
        this.history = new ContainerHistory();
        this.history.add(initialVolume);
        super.addToTheContainer(initialVolume);
    }
    
    public String history(){
        return this.history.toString();
    }
   
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(super.getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount){
        double x = super.takeFromTheContainer(amount);
        history.add(super.getVolume());
        return x;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history);
        System.out.println("Greatest product amount: " + history.maxValue());
        System.out.println("Smallest product amount: " + history.minValue());
        System.out.println("Average: " + history.average());
        System.out.println("Greatest change: " + history.greatestFluctuation());
        System.out.println("Variance: " + history.variance());
    }
}
