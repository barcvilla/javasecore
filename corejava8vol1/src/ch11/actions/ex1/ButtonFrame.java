/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.actions.ex1;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public class ButtonFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public ButtonFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // creamos buttons
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        
        buttonPanel = new JPanel();
        
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        
        // adicionamos al JFrame
        add(buttonPanel);
        
        // creamos las acciones para los botones
        ColorActions yellowAction = new ColorActions(Color.YELLOW);
        ColorActions blueAction = new ColorActions(Color.BLUE);
        ColorActions redAction = new ColorActions(Color.RED);
        
        
    }
}
