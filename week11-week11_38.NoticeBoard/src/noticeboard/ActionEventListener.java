/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.*;

/**
 *
 * @author Linh Nguyen
 */
public class ActionEventListener implements ActionListener {

    private JTextField top;
    private JLabel bottom;

    public ActionEventListener(JTextField left, JLabel right) {
        this.top = left;
        this.bottom = right;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.bottom.setText(this.top.getText());
        this.top.setText("");

    }
}
