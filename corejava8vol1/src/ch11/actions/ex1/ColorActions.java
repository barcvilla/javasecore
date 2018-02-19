/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.actions.ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public class ColorActions extends AbstractAction implements ActionListener
{
    //private Color backgroundColor;
    private static JPanel buttonPanel;

    public ColorActions(String name, Icon icon, Color c)
    {
        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
        putValue("Color", c);
        //backgroundColor = c;
    }
    
    public static void setpanel(JPanel bPanel)
    {
        buttonPanel = bPanel;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Color c = (Color) getValue("color");
        buttonPanel.setBackground(c);
    }
}
