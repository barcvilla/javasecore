/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.actions.ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author PC
 */
public class ActionFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public ActionFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        buttonPanel = new JPanel();
        
        /* definimos acciones */
        Action redAction = new ColorAction("Red", new ImageIcon("ball_red.png"), Color.RED);
        
        /* adicionamos botones para estas acciones */
        buttonPanel.add(new JButton(redAction));
        
        /* asociamos R key con el nombre */
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        /* se aplica cuando el formulario tiene el foco */
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        
        /* asociamos el nombres con acciones */
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.red", redAction);
        
        /* adicionamos al panel */
        add(buttonPanel);
    }
    
    public static void main(String[] args) {
        new ActionFrame();
    }
    
    public class ColorAction extends AbstractAction
    {
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set Panel color to " +  name.toLowerCase());
            putValue("color", c);
        }
        
        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
