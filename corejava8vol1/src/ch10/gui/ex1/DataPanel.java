/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.gui.ex1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author barcvilla
 */
public class DataPanel extends JPanel
{
    public DataPanel()
    {
        try
        {
            jbInit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    // ----- Static UI Objects
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private JLabel lblMessage = new JLabel();
    
    private void jbInit() throws Exception
    {
        this.setLayout(gridBagLayout);
        
        lblMessage.setText("Java Hello world! ");
        this.add(lblMessage, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 
                GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 2, 5), 0, 0));
    }
}
