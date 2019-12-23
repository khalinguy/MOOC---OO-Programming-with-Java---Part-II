import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private SavageCalculator calculatorLogic;
    private JButton reset;
    private JTextField input;
    private JTextField output;

    public GraphicCalculator() {
        this.calculatorLogic = new SavageCalculator();
    }

    public JTextField getInput() {
        return input;
    }

    public JTextField getOutput() {
        return output;
    }

    public JButton getReset() {
        return reset;
    }

    public SavageCalculator getCalculatorLogic() {
        return calculatorLogic;
    }

    public int getOutputValue() {
        return Integer.parseInt(this.toString(this.output));
    }
    
    public int getInputValue() {
        return Integer.parseInt(this.toString(this.input));
    }
    
    public boolean isInputInteger() {
        try {
            Integer.parseInt(this.toString(this.input));
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public String toString(JTextField JTextField) {
        return JTextField.getText();
    }

    @Override
    public void run() {
        this.frame = new JFrame("Calculator");
        this.frame.setPreferredSize(new Dimension(300, 150));
        this.frame.setLayout(new GridLayout(3, 1));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        output = new JTextField("0");
        output.setEnabled(false);

        input = new JTextField("0");

        container.add(output);
        container.add(input);
        container.add(createPanel(output, input), BorderLayout.SOUTH);
    }

    private JPanel createPanel(JTextField output, JTextField input) {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        reset = new JButton("Z");
        reset.addActionListener(new SetZeroListener(this));
        reset.setEnabled(false);

        JButton add = new JButton("+");
        add.addActionListener(new IncreaseListener(this));

        JButton subtract = new JButton("-");
        subtract.addActionListener(new DecreaseListener(this));

        panel.add(add);
        panel.add(subtract);
        panel.add(reset);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}