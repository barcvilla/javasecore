/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.layout.manager;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author PC
 */
public class GBC extends GridBagConstraints
{
    /**
     * Construimos un GriBagConstraint (GBC) con una posicion gridx y gridy dada. El conjunto de valores del Bag Constraints
     * seteado a default
     * @param gridx 
     * @param gridy 
     */
    public GBC(int gridx, int gridy)
    {
        this.gridx = gridx;
        this.gridy = gridy;
    }
    
    /**
     * Construye GBC con un gridx, gridy, gridwidth, gridheight. Todos los demas gbc permanecen en default
     * @param gridx
     * @param gridy
     * @param gridwidth - cell span en direccion x
     * @param gridheight - cell span en direccion y
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight)
    {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }
    
    /**
     * Set the anchor
     * @param anchor - anchor value
     * @return this object para mayor modificacion
     */
    public GBC setAnchor(int anchor)
    {
        this.anchor = anchor;
        return this;
    }
    
    /**
     * Set el fill direction
     * @param fill - fill direction
     * @return this object para mayor modificacion
     */
    public GBC setFill(int fill)
    {
        this.fill = fill;
        return this;
    }
    
    /**
     * Set cell weights
     * @param weightx - cell weight en direccion x
     * @param weighty - cell weight en direccion y
     * @return this object para mas modificacion
     */
    public GBC setWeight(double weightx, double weighty)
    {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
    
    /**
     * Sets insets a esta celda
     * @param distance - spacio para usar en todas las direcciones
     * @return este objeto para mayor modificacion
     */
    public GBC setInsets(int distance)
    {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }
    
    /**
     * Set insets en esta celda
     * @param top - top spacing use on top
     * @param left
     * @param bottom
     * @param right
     * @return 
     */
    public GBC setInsets(int top, int left, int bottom, int right)
    {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }
    
    /**
     * Set internal padding
     * @param ipadx - internal padding en direccion x
     * @param ipady - internal padding en direccion y
     * @return  este objeto para su modificacion
     */
    public GBC setIpad(int ipadx, int ipady)
    {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
    
    
}
