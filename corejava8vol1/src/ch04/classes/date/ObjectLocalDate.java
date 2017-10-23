/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.date;

import java.time.LocalDate;

/**
 *
 * @author jcva175
 */
public class ObjectLocalDate {
    public static void main(String[] args)
    {
        addDaysToDate(5);
    }

    private static void addDaysToDate(int days)
    {
        LocalDate birth = LocalDate.of(1982, 07, 20);
        System.out.println("Fecha cumpleaños: " +  birth);

        birth = birth.plusDays(days);
        System.out.println("Nueva fecha : " + birth);
    }

    private static void divideDate()
    {
        LocalDate date = LocalDate.of(1982, 07, 20);
        System.out.println("El año: " + date.getYear());
        System.out.println("El mes es: " + date.getMonthValue());
        System.out.println("El dia es: " + date.getDayOfMonth());
    }

    private static void printNowDate()
    {
        System.out.println("La fecha de hoy es: " + LocalDate.now().toString());
    }

    private  static  void buildDate()
    {
        LocalDate date = LocalDate.of(1982, 07, 20);
        System.out.println("Mi cumpleaños es: " + date);
    }
    
}
