/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.actions.ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public class ColorActions implements ActionListener 
{
    private Color backgroundColor;
    private JPanel buttonPanel;
    public ColorActions(Color c)
    {
        backgroundColor = c;
    }
    
    public void setpanel(JPanel buttonPanel)
    {
        this.buttonPanel = buttonPanel;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        buttonPanel.setBackground(backgroundColor);
    }
}
