/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.generics.ex1;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author barcvilla
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = 
        {
            LocalDate.of(1906, 12, 9),
            LocalDate.of(1815, 12, 10),
            LocalDate.of(1903, 12, 3),
            LocalDate.of(1910, 6, 22),
        };
        
        Pair<LocalDate> mm = ArrayAlg2.<LocalDate>minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg2
    {
        /**
         * Obtenemos el minimo y maximo de un arreglo d tipo T
         * @param a es un array de objetos de tipo T
         * @return a objeto de tipo Pair con los valores min y max o nulo si a es nulo o vacio.
         */
        public static <T extends Comparable> Pair<T> minmax(T[] a)
        {
            if(a == null || a.length == 0)
            {
                return null;
            }
            
            T min = a[0];
            T max = a[0];
            
            for(int i = 1; i < a.length; i++)
            {
                if(min.compareTo(a[i]) > 0)
                {
                    min = a[i];
                }
                
                if(max.compareTo(a[i]) < 0)
                {
                    max = a[i];
                }
            }
            return new Pair<T>(min, max);
        }
    }
