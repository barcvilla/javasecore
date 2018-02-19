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
 * @author barcvilla
 */
public class ButtonFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;
    
    public ButtonFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        buttonPanel = new JPanel();
        //ColorActions.setpanel(buttonPanel);
        
        // definimos acciones
        // creamos las acciones para los botones
        Action yellowAction = new ColorAction("Yellow", new ImageIcon("ball_red.png"), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon("ball_red.pgn"), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon("ball_red.png"), Color.RED);
        
        // creamos buttons
        JButton yellowButton = new JButton(yellowAction);
        JButton blueButton = new JButton(blueAction);
        JButton redButton = new JButton(redAction);
        
        //Adicionamos los botones al Panel.
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);        
        
        // asociamos Red, Blue y Yellow con nombres
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        
        // asociamos los nombres con acciones
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
        
        // adicionamos al JFrame
        add(buttonPanel);
        
    }

    public class ColorAction extends AbstractAction
    {

        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("Color", c);
        }
    
        public void actionPerformed(ActionEvent e)
        {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
    
    public static void main(String[] args)
    {
        new ButtonFrame();
    }
}


