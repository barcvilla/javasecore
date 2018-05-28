/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch12.userinterface.menus;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author PC
 */
public class MenuFrame extends JFrame 
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private Action saveAction;
    private Action saveAsAction;
    
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popup;
    
    public MenuFrame()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        
        JMenu fileMenu  = new JMenu("File");
        fileMenu.add(new TestAction("New"));
        
        /*aplicamos shortcuts*/
        JMenuItem openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        
        fileMenu.addSeparator();
        
        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("crtl S"));
        
        saveAsAction = new TestAction("Save As");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();
        
        fileMenu.add(new AbstractAction("Exit")
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
        
        /*demostramos el uso de CheckBox y Radio Buttons*/
        readOnlyItem = new JCheckBoxMenuItem("Ready-Only");
        readOnlyItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                boolean saveOk =!readOnlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });
        
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overTypeItem = new JRadioButtonMenuItem("OverType");
        
        group.add(insertItem);
        group.add(overTypeItem);
        
        /*aplicamos iconos en los menu*/
        Action cutAction = new TestAction("Cut"); 
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("assetDownload.gif"));
        Action copyAction = new TestAction("Copy");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("basket.gif"));
        Action pasteAction = new TestAction("Paste");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("calculator16.gif"));
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
        /*mostramos menu anidado*/
        JMenu optionMenu = new JMenu("Options");
        optionMenu.add(readOnlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overTypeItem);
        
        editMenu.addSeparator();
        editMenu.add(optionMenu);
        
        /*Usamos short cuts*/
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        
        JMenuItem indexItem = new JMenuItem("Index");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);
        
        /*Podemos adicionar mnemonic key a una accion*/
        Action aboutAction = new TestAction("About");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
        helpMenu.add(aboutAction);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        
        /*Uso de pop up menu*/
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);
        
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
    
    /*
    * Una accion de ejemplo que imprime el nombre de la accion
    */
    class TestAction extends AbstractAction
    {
        public TestAction(String name)
        {
            super(name);
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println(getValue(Action.NAME) + " Selected");
        }
    }
    
    public static void main(String[] args) {
        new MenuFrame();
    }
}
