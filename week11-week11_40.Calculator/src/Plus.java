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
public class Plus implements ActionListener{
    private JTextField input;
    private JTextField output;
    private JButton clear;
    
    public Plus(JTextField input, JTextField output, JButton clear){
        this.input = input;
        this.output = output;
        this.clear = clear;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int out = 0;
        try{
            int in = Integer.parseInt(input.getText());
            out += Integer.parseInt(output.getText());
            out += in;
            this.input.setText("");
            this.output.setText("" + out);
            clear.setEnabled(true);
        }
        catch(Exception e){
            this.input.setText("");
        }
    }
    
}
