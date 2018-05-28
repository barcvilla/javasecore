/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.menus;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class ToolBarFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;
    
    public ToolBarFrame()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        
        /*adicionamos un panel para el cambio de color*/
        
    }
    
    /**
     * el color action establece background del frame
     */
    class ColorAction extends AbstractAction
    {
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + "background");
            putValue("Color", c);
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color)getValue("Color");
            panel.setBackground(c);
        }
    }
}
