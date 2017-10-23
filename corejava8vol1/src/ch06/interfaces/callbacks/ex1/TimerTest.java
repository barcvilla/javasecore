/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.interfaces.callbacks.ex1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jcva175
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        // construimos un timer que llama al listener
        Timer timer = new Timer(10000, listener);
        timer.start();
        
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimerPrinter implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("At the tone, the time is..." + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
