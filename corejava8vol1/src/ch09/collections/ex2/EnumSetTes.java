/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex2;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author barcvilla
 */
public class EnumSetTes 
{
    public static void main(String[] args) 
    {
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> worday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        
        // using iterator
        Iterator<Weekday> iter = always.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
        
        // iterating simple form
        for(Weekday week : always)
        {
            System.out.println(week);
        }
    }
}
