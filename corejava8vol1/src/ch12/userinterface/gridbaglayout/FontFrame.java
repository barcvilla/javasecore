/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.gridbaglayout;

import ch12.userinterface.layout.manager.GBC;
import java.awt.AWTEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author PC
 */
public class FontFrame extends JFrame
{
    private static final int TEXT_ROWS = 10;
    private static final int TEXT_COLUMNS = 20;
    
    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JCheckBox underLine;
    private JTextArea sample;
    
    public FontFrame()
    {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        ActionListener listener = event -> updateSample();
        
        /*Construccion de Componentes*/
        JLabel faceLabel = new JLabel("Face: ");
        face =new JComboBox<>(new String[]{"Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput"});
        face.addActionListener(listener);
        
        JLabel sizeLabel = new JLabel("Size: ");
        size = new JComboBox<>(new Integer[]{8, 10, 12, 15, 18, 24, 38, 48});
        size.addActionListener(listener);
        
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        
        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        
        underLine = new JCheckBox("UnderLine");
        underLine.addActionListener(listener);
        
        sample = new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
        sample.setText("The quick brown fox jumps over the lazy dog");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());
        
        /*add componentes al grid, usando la clase GBC*/
        add(faceLabel, new GBC(0,0).setAnchor(GBC.EAST));
        add(face, new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
        add(sizeLabel, new GBC(0,1).setAnchor(GBC.EAST));
        add(size, new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
        add(bold, new GBC(0,2,2,1).setAnchor(GBC.WEST).setWeight(100, 100));
        add(italic, new GBC(0,3,2,1).setAnchor(GBC.WEST).setWeight(100, 100));
        add(underLine, new GBC(0,4,2,1).setAnchor(GBC.WEST).setWeight(100, 100));
        add(sample, new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
        pack();
        updateSample();
        
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
    }
    
    public void updateSample()
    {
        String fontFace = (String)face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        Font font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
    
    public static void main(String[] args) {
        new FontFrame();
    }
}
