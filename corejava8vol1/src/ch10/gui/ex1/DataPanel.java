/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.gui.ex1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author barcvilla
 */
public class DataPanel extends JPanel implements ActionListener
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
    
    private static ImageIcon iOpen = new ImageIcon(DataPanel.class.getResource("openFile.gif"));
    private static final int FIELDLENGTH = 15;
    // ----- Static UI Objects
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private JLabel lblMessage = new JLabel();
    private JTextField fldMessage = new JTextField(FIELDLENGTH);
    private JButton btnMessage = new JButton(iOpen);
    
    private void jbInit() throws Exception
    {
        this.setLayout(gridBagLayout);
        
        lblMessage.setText("Java Hello world! ");
        this.add(lblMessage, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, 
                GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 2, 5), 0, 0));
        this.add(fldMessage, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, 
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(5, 5, 5, 0), 0, 0));
        this.add(btnMessage, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 2, 5), 0, 0));
        
        btnMessage.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnMessage)
        {
            greeting();
        }
    }
    
    //-- action metodos
    private void greeting()
    {
        JOptionPane.showConfirmDialog(null, "Hello world!", "Aviso",JOptionPane.OK_OPTION);
    }
}
