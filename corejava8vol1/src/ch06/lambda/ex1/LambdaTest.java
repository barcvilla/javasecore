/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jcva175
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn",
        "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Orden Alfabetico");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Ordena por la longitud");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
        
        Timer tm = new Timer(10000, event->
        {
            System.out.println("the time is " + new Date());
        });
        tm.start();
        
        JOptionPane.showConfirmDialog(null, "Quit program");
        System.exit(0);
    }
}
