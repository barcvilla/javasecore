/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.gui.apps;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author barcvilla
 */
public final class AppsAction extends AbstractAction 
{
    /** Button Size     			*/
    public static final Dimension	BUTTON_SIZE = new Dimension(28,28);
    /** Button Insets   			*/
    public static final Insets		BUTTON_INSETS = new Insets(0, 0, 0, 0);
    /** CButton or CToggelButton	*/
    private AbstractButton 	m_button;
    /**	Menu						*/
    private JMenuItem		m_menu;
    private String		m_action = null;
    private KeyStroke		m_accelerator = null;
    private Icon 		m_smallPressed = null;
    private ActionListener	m_delegate = null;
    private boolean 		m_toggle = false;
    private boolean		m_pressed = false;
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}
