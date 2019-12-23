import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author W
 */
public class SetZeroListener implements ActionListener {

    private SavageCalculator calculatorLogic;
    private GraphicCalculator calculatorUI;
    private JTextField input;
    private JTextField output;
    private JButton reset;

    public SetZeroListener(GraphicCalculator calculatorUI) {
        this.calculatorUI = calculatorUI;
        this.calculatorLogic = this.calculatorUI.getCalculatorLogic();
        this.input = this.calculatorUI.getInput();
        this.output = this.calculatorUI.getOutput();
        this.reset = this.calculatorUI.getReset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorLogic.setZero();
        this.output.setText("" + this.calculatorLogic.getValue());
        this.input.setText("");
        this.reset.setEnabled(false);
    }

}