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
    
    public GBC setInsets(int distance)
    {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }
}
