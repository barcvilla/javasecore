/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.innerclass.ex1;

import javax.swing.JOptionPane;

/**
 *
 * @author jcva175
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10000, true);
        clock.start();
        
        JOptionPane.showConfirmDialog(null, "Salir del programa");
        System.exit(0);
    }
}
