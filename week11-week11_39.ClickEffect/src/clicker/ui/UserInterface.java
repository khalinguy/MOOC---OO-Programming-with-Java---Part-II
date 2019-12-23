package clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.*;
import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

public class UserInterface implements Runnable {
    private Calculator cal;
    private JFrame frame;

    public UserInterface (Calculator cal){
        this.cal = cal;
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
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        
        JLabel origin = new JLabel("" + cal.giveValue());
        JButton click = new JButton("Click!");
        ClickListener listener = new ClickListener (this.cal, origin);
        click.addActionListener(listener);
        
        container.add(origin, BorderLayout.NORTH);
        container.add(click, BorderLayout.SOUTH);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
