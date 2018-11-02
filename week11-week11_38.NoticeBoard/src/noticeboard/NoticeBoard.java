package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        JTextField top = new JTextField();
        JLabel bottom = new JLabel();
        JButton copy = new JButton("Copy!");
        ActionEventListener copier = new ActionEventListener(top, bottom);
        copy.addActionListener(copier);
        container.add(top);
        container.add(copy);
        container.add(bottom);
    }
}
