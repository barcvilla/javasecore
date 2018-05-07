/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.layout;

import ch11.eventhandling.ex1.DataPanel11;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class CalculatorForm extends JFrame
{
    private BorderLayout borderLayout = new BorderLayout();
    private JPanel contentPane;
    private CalculatorPanel dataPanel = new CalculatorPanel();
    
    private CalculatorForm()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        
        try
        {
            jbInit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    private void jbInit() throws Exception
    {
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(borderLayout);
        contentPane.add(dataPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        new CalculatorForm();
    }
}
