/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

/**
 *
 * @author Linh Nguyen
 */
public class ClickListener implements ActionListener{
    private JLabel label;
    private Calculator calculator;
    
    public ClickListener(Calculator calculator, JLabel text){
        this.label = text;
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        label.setText(Integer.toString(calculator.giveValue()));
    }
    
}
