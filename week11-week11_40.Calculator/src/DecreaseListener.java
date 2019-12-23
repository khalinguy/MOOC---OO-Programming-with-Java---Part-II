import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author W
 */
public class DecreaseListener implements ActionListener {

    private SavageCalculator calculatorLogic;
    private GraphicCalculator calculatorUI;
    private JTextField input;
    private JTextField output;
    private JButton reset;

    public DecreaseListener(GraphicCalculator calculatorUI) {
        this.calculatorUI = calculatorUI;
        this.calculatorLogic = this.calculatorUI.getCalculatorLogic();
        this.input = this.calculatorUI.getInput();
        this.output = this.calculatorUI.getOutput();
        this.reset = this.calculatorUI.getReset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.calculatorUI.isInputInteger()) {
            this.calculatorLogic.decrease(this.calculatorUI.getInputValue());
            this.output.setText("" + this.calculatorLogic.getValue());
            this.input.setText("");
            if (this.calculatorUI.getOutputValue() == 0) {
                this.reset.setEnabled(false);
            } else {
                this.reset.setEnabled(true);
            }
        } else {
            this.input.setText("");
        }
    }
}