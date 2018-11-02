/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Cody
 */
public class Clear implements ActionListener{
    private JTextField output;
    private JTextField input;
    private JButton clear;
    
    public Clear(JTextField input, JTextField output, JButton clear){
        this.output = output;
        this.input = input;
        this.clear = clear;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(Integer.parseInt(output.getText()) == 0){
             
         }
         else{
             output.setText("0");
             input.setText("");
             clear.setEnabled(false);
         }
    }
}
