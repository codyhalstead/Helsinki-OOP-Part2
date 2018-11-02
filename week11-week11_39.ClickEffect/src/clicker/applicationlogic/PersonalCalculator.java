/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author Cody
 */
public class PersonalCalculator implements Calculator{
    private int value = 0;

    @Override
    public int giveValue() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void increase() {
        value++; //To change body of generated methods, choose Tools | Templates.
    }
    
}
