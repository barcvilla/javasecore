/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14.concurrency.basics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    
    private java.util.List<Ball> balls = new ArrayList<>();
    
    /*Adicionamos una bola al componente*/
    public void add(Ball b)
    {
        balls.add(b);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); //borramos el background
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls)
        {
            g2.fill(b.getShape());
        }
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
