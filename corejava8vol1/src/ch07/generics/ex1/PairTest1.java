/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.generics.ex1;

/**
 *
 * @author barcvilla
 */
public class PairTest1 {
    public static void main(String[] args) {
        Integer[] words = {3,7,6,9,2,78,3,4};
        Pair<Integer> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg
{
    /**
     * Obtenemos el menor y mayor de un array de strings
     * @param un array de strings
     * @return un par con el valor maximo y menor o nulo si es nulo o vacio
     */
    public static Pair<Integer> minmax(Integer[] a)
    {
        if(a == null || a.length == 0)
        {
            return null;
        }
        
        Integer min = a[0];
        Integer max = a[0];
        
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
        return new Pair<>(min, max);
    }
    // Generic Method
    public static <T> T getMiddle(T...a)
    {
        return a[a.length / 2];
    }
    
    /** Metodo Generic min (limites para los tipos de variable)
     * Metodo min que puede ser sola llamado con arrays de clases que implementan la interface Comparable
     * <T debe ser un subtipo Comparable>
     * Calcular el elemento menor en un Array
     * @param <T> restringimos la clase de tipo T a una que implemente la interface Comparable
     * @param a
     * @return 
     */
    public static <T extends Comparable> T min(T[] a)
    {
        if(a == null || a.length == 0)
        {
            return null;
        }
        
        T smallest = a[0];
        for(int i = 1; i < a.length; i++)
        {
            if(smallest.compareTo(a[i]) > 0)
            {
                smallest = a[i];
            }
        }
        return smallest;
    }
}
