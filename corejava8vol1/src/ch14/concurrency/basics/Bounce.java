/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14.concurrency.basics;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class Bounce {
    public static void main(String[] args) {
        {
            EventQueue.invokeLater(() ->{
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            });
        }
    }
}
