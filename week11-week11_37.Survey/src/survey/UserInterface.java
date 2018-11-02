package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200,300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }


    public JFrame getFrame() {
        return frame;
    }
    
    public void createComponents(Container container){
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(new JLabel("Are you?"));
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        container.add(yes);
        container.add(no);
        container.add(new JLabel("Why?"));
        JRadioButton nr = new JRadioButton("No reason.");
        JRadioButton biif = new JRadioButton("Because it is fun!");
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(nr);
        bGroup.add(biif);
        container.add(nr);
        container.add(biif);
        JButton done = new JButton("Done!");
        container.add(done);
    }
}
