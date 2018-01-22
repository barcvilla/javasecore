/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.eventhandling.ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author barcvilla
 */
public class ColorAction extends AbstractAction
{
    JButton button;
    public ColorAction(String name, Icon icon, Color c)
    {
        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, "Set button color " + name.toLowerCase());
        putValue("color", c);
    }
    
    public void setButton(JButton b)
    {
        button = b;
    }
    
    private void setColor(Color c)
    {
        button.setBackground(c);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        Color c = (Color) getValue("color");
        setColor(c);
    }
}
