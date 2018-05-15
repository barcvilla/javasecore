/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.layout;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class CheckBoxFrame extends JFrame{
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;
    
    public CheckBoxFrame()
    {
        /*adicionamos texto ejemplo a la etiqueta*/
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);
        
        /*este listener establece el atributo font del label hacia el estado del check box*/
        ActionListener listener = event ->
        {
            int mode = 0;
            if(bold.isSelected())
            {
                mode += Font.BOLD;
                System.out.println("bold: " + mode);
            }
            if(italic.isSelected())
            {
                mode += Font.ITALIC;
                System.out.println("italic: " + mode);
            }
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };
        
        /*Adicionamos checkboxs*/
        JPanel buttonPanel = new JPanel();
        
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);
        
        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);
        
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new CheckBoxFrame();
    }
}
