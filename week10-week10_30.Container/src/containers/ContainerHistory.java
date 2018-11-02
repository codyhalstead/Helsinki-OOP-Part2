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
public class ContainerHistory {
    private List<Double> history;
    
    public ContainerHistory(){
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation){
        history.add(situation);
    }
    
    public void reset(){
        history.clear();
    }
    
    @Override
    public String toString(){
        return history.toString();
    }
    
    public double maxValue(){
        if(history.isEmpty()){
            return 0;
        }
        double x = 0;
        for(double i : history){
            if(i > x){
                x = i;
            }
        }
        return x;
    }
    
    public double minValue(){
            if(history.isEmpty()){
            return 0;
        }
        double x = history.get(0);
        for(double i : history){
            if(i < x){
                x = i;
            }
        }
        return x;
    }
    
    public double average(){
        if(history.isEmpty()){
            return 0;
        }
        double x = 0;
        for(double i : history){
            x += i;
        }
        return x/history.size();
    }
    
    public double greatestFluctuation(){
        if(history.isEmpty() || history.size() == 1){
            return 0;
        }
        double max = 0;
        for(int i = 0; i < history.size()-1; i++){
            double fluct = Math.abs(history.get(i) - history.get(i+1));
            System.out.println(fluct);
            if(fluct > max){
                max = fluct;
            }
        }
        return max;
    }
    
    public double variance(){
        if(history.isEmpty() || history.size() == 1){
            return 0;
        }
        double helper = 0;
        for(double i : history){
            helper += (i - this.average()) * (i - this.average());
        }
        return helper/(history.size() - 1);
    }
}
