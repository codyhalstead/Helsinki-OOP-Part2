/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Cody
 */
public class ConstantSensor implements Sensor {
    private int imput;
    
    public ConstantSensor(int input){
        this.imput=input;
    }

    @Override
    public boolean isOn() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void on() {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        return imput;
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
