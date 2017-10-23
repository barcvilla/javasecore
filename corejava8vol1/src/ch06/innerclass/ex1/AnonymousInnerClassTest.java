/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.innerclass.ex1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 *
 * @author jcva175
 */
public class AnonymousInnerClassTest { 
    public static void main(String[] args) {
        TalkingClocks clock = new TalkingClocks();
        clock.start(1000, true);
        
        // el programa se mantiene en ejecucion hasta que se presiona ok
        JOptionPane.showMessageDialog(null, "Quit program?");
        
        System.exit(0);
    }
    
}

// Un reloj que imprime la hora en un tiempo de intervalo regular
class TalkingClocks
    {
        /**
         * Inicia el reloj
         * @param interval : el intervalo entre los mensajes (milisegundos)
         * @param beep : true si el reloj debe emitir un sonido (beep)
         */
        public void start(int interval, boolean beep)
        {
            ActionListener listener = new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    System.out.println("at the tone, the time is: " + new Date());
                    if(beep)
                    {
                        Toolkit.getDefaultToolkit().beep();
                    }
                }
            };
            
            Timer time = new Timer(interval, listener);
            time.start();
        }
    }
