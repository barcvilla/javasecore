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
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author PC
 */
public class RadioButtonFrame extends JFrame{
    
    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;
    
    public RadioButtonFrame()
    {
        /*adicionamos texto ejemplo al label*/
        label = new JLabel("The quick brown fox jump over the lazy dog");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE)); 
        add(label, BorderLayout.CENTER);
        
        /*Adicionamos los radios button*/
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        
        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra Large", 36);
        
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

    }
    
    /**
     * Adicionamos radio buttons que establece el font size de texto de ejemplo
     * @param name - el nombre que aparece en el button
     * @param size - tamano de letra para este conjunto de botones
     */
    public void addRadioButton(String name, int size)
    {
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);
        
        /*este listener establece el tamano de fuente al label*/
        ActionListener listener = event ->
        {
            label.setFont(new Font("Serif", Font.PLAIN, size));
        };
        button.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        new RadioButtonFrame();
    }
}
