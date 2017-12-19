/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.gui.apps;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public final class ConfirmPanel extends JPanel
{
    /** Botones adicionales  */
    private JButton bOk;
    private JButton bCancel;
    /**************************************/
    /** Standard Insets usados            */
    public static Insets s_insets = new Insets(0, 10, 0, 10);
    
    /** Action String Ok                */
    public static final String A_OK = "OK";
    public static final String A_Cancel = "CANCEL";
    
    /** Panel botones adicionales  */
    private JPanel m_addButtons = null;
    /**
     * Crea un boton OK con un label text y F4 shortcut
     */
    public static final JButton createOKButton(String text)
    {
        JButton b = new JButton("Ok");
        return b;
    }
    
    /**
     * Add button al lado izq del confirma panel.
     * @param button 
     */
    public void addComponent(Component button)
    {
    }
    
    public JButton getOkButton()
    {
        return bOk;
    }
    
    public JButton getCancelButton()
    {
        return bCancel;
    }
}
