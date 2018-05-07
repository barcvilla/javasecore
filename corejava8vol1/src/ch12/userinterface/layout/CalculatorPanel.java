/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.layout;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class CalculatorPanel extends JPanel{
    
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    
    public CalculatorPanel()
    {
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        
        /*Add the display*/
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        
        // adicionamos los botones en un grid de 4 x 4
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);
        
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);
        
        add(panel, BorderLayout.CENTER);
    }
    
    /**
     * Adicionamos un button al center panel
     * @param label - button label
     * @param listener - button listener
     */
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
    
    /**
     * Esta accion inserta button action string al final del display text
     */
    private class InsertAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if(start)
            {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    
    /**
     * Esta accion ejecuta el comando que denota el button action string
     */
    private class CommandAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if(start)
            {
                if(command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else
                {
                    lastCommand = command;
                }
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
        
        public void calculate(double x)
        {
            if(lastCommand.equals("+")) result += x;
            else if(lastCommand.equals("-")) result -= x;
            else if(lastCommand.equals("*")) result *= x ;
            else if(lastCommand.equals("/")) result /= x;
            else if(lastCommand.equals("=")) result = x;
            display.setText("" + result);
        }
    }

}

