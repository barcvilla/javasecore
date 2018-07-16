/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14.concurrency.basics;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author PC
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
    
    /*movemos la bola a la sgte posiciones, aplica direccion reversa si llega al limite del frame*/
    public void move(Rectangle2D bounds)
    {
        x += dx;
        y += dy;
        
        if(x < bounds.getMinX())
        {
            x = bounds.getMinX();
            dx = -dx;
        }
        
        if(x + XSIZE >= bounds.getMaxX())
        {
            x = bounds.getMinY();
            dy = -dy;
        }
        
        if(y + YSIZE >= bounds.getMaxY())
        {
           y =bounds.getMaxY() - YSIZE;
           dy = -dy;
        }
    }
    
    /*Obtenemos la forma de la bola y su posicion actual*/
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
