/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch11.eventhandling.ex1;

import ch10.gui.ex1.DataPanel;
import ch10.gui.ex1.EnvironUtils;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public class MyListener1 extends JFrame
{
    private BorderLayout borderLayout = new BorderLayout();
    private JPanel contentPane;
    private DataPanel11 dataPanel = new DataPanel11();
    
    public MyListener1()
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
    
    public static void main(String[] args) 
    {
        new MyListener1();
    }
}
