package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        // Create your app here
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        ButtonGroup buttonGroup = new ButtonGroup();
        container.setLayout(layout);
        container.add(new JLabel("Are you?"));

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");


        buttonGroup.add(yes);
        buttonGroup.add(no);

        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));

        JRadioButton noreason = new JRadioButton("No reason.");
        JRadioButton funnyreason = new JRadioButton("Because it is fun!");


        buttonGroup.add(noreason);
        buttonGroup.add(funnyreason);

        container.add(noreason);
        container.add(funnyreason);

        JButton done = new JButton("Done!");
        container.add(done);

    }

    public JFrame getFrame() {
        return frame;
    }
}
