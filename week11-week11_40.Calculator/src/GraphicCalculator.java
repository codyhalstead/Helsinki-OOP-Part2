
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField output = new JTextField("0");
        JTextField input = new JTextField();
        output.setEnabled(false);
        
        JButton minus = new JButton("-");
        JButton clear = new JButton("Z");
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        plus.addActionListener(new Plus(input, output, clear));
        panel.add(plus);
        minus.addActionListener(new Minus(input, output, clear));
        panel.add(minus);
        clear.addActionListener(new Clear(input, output, clear));
        clear.setEnabled(false);
        panel.add(clear);
        container.add(output);
        container.add(input);
        container.add(panel, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel createPanel(){
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Z"));
        
        return panel;
    }
}