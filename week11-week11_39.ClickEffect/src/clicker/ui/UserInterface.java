package clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import clicker.applicationlogic.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calc;
    
    public UserInterface(Calculator calc){
        this.calc = calc;
    }
    
    public UserInterface(){
        this.calc = new PersonalCalculator();
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel calculatorLabel = new JLabel();
        calculatorLabel.setText("" + calc.giveValue());
 
        JButton button = new JButton();
        button.setText("Click!");
        button.addActionListener(new ClickListener(calc, calculatorLabel));
 
        container.add(calculatorLabel);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
