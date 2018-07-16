/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14.concurrency.basics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
    
    /**
     * Construimos el Frame con el componente para mostrar la bola y los 
     * botones start y Close
     */
    
    public BounceFrame()
    {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Adicionamos un boton al container
     * @param c el contenedor
     * @param title titulo del boton
     * @param listener action listener para el boton
     */
    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
    
    /**
     * Adicionamos la bola al panel y la hacemos mover 1000 veces
     */
    public void addBall()
    {
        try
        {
            Ball ball = new Ball();
            comp.add(ball);
            for(int i = 1; i <= STEPS; i++)
            {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException e)
        {}
    }
    
}
