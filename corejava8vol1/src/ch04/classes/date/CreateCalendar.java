/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author jcva175
 */
public class CreateCalendar {

    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today -1); // inicio del mes
        DayOfWeek weekDay= date.getDayOfWeek();
        int value = weekDay.getValue();

        System.out.println("Lun Mar Mie Jue Vie Sab Dom");
        for(int i = 1; i < value; i++)
        {
            System.out.print("  ");
        }
        while(date.getMonthValue() == month)
        {
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1)
            {
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1)
        {
            System.out.println();
        }
    }    
}
