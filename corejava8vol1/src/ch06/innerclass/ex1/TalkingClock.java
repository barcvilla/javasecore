/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.innerclass.ex1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author jcva175
 */
public class TalkingClock {
    private int interval;
    private boolean beep;
    
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }
    
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer time = new Timer(interval, listener);
        time.start();
    }
    
    public class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("La fecha es: " + new Date());
            if(beep)
            {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
