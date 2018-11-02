/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import clicker.applicationlogic.*;
/**
 *
 * @author Cody
 */
public class ClickListener implements ActionListener{
    private JLabel label;
    private Calculator calc;
    
    public ClickListener(Calculator calc, JLabel label){
        this.calc = calc;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         calc.increase();//To change body of generated methods, choose Tools | Templates.
         this.label.setText(Integer.toString(calc.giveValue()));
    }
    
}
