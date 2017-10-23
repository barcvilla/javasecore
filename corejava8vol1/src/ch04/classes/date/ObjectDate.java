/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.date;

import java.util.Date;

/**
 *
 * @author jcva175
 */
public class ObjectDate {
    public static void main(String args[])
    {
        printStringDate();
    }

    private static void printDate()
    {
        System.out.println(new Date());
    }

    private static void printStringDate()
    {
        String date = new Date().toString();
        System.out.println(date);
    }
    
}
