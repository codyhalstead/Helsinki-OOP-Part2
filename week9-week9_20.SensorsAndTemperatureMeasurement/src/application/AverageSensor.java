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
public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    private ArrayList<Integer> readings = new ArrayList<Integer>();
    
    public void addSensor(Sensor additional){
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for(Sensor i : sensors){
            if(!i.isOn()){
                return false;
            }
        }
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void on() {
        for(Sensor i : sensors){
            i.on();
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
        for(Sensor i : sensors){
            i.off();
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        if(isOn()){
            int total = 0;
            int count = 0;
            for(Sensor i : sensors){
                total+=i.measure();
                count++;
            }
            int av = total/count;
            readings.add(av);
            return av;
        }
        else{
            throw new IllegalStateException("All sensors must be on.");
        }
    }
    
    public List<Integer> readings(){
        return readings;
    }
    
}
