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
public class Minus implements ActionListener{
    private JTextField input;
    private JTextField output;
    private JButton clear;
    
    public Minus(JTextField input, JTextField output, JButton clear){
        this.input = input;
        this.output = output;
        this.clear = clear;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            int in = Integer.parseInt(input.getText());
            int out = Integer.parseInt(output.getText());
            out = out - in;
            this.input.setText("");
            this.output.setText("" + out);
            clear.setEnabled(true);
        }
        catch(Exception e){
            this.input.setText("");
        }
    }
    
}
