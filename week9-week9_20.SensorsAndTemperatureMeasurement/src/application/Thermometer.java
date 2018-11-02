/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.*;

/**
 *
 * @author Cody
 */
public class Thermometer implements Sensor{
    private int x = 0;
    private Random rand = new Random();

    @Override
    public boolean isOn() {
       if(this.x==0){
           return false;//To change body of generated methods, choose Tools | Templates.
       }else{
           return true;
       }
    }

    @Override
    public void on() {
        this.x=1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
        this.x=0; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        if(isOn()){ 
            return rand.nextInt(61)-30;//To change body of generated methods, choose Tools | Templates.
    }   else{
            throw new IllegalStateException("Thermometer must be on to measure.");
        }
    
}
}
