/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.expressions;

import java.util.*;

/**
 *
 * @author barcvilla
 */
public class LambdaDemo2 
{
    public static void SimpleComparatorExample()
    {
        // creamos una lista no ordenada.
        List<Integer> list = Arrays.asList(1,2,9,80,50,4,25,7);
        
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return a.compareTo(b);
            }
        });
    }
    
    public static void LambdaComparator()
    {
        // creamos una lista no ordenada.
        List<Integer> list = Arrays.asList(1,2,9,80,50,4,25,7);
       
        // mostrando tipos de datos de parametros + entre llaves + return
        Collections.sort(list, (Integer a, Integer b) -> {return a.compareTo(b);});
        
        // mostrando solo tipo de datos de los parametros
        Collections.sort(list, (Integer a, Integer b) -> a.compareTo(b));
        
        // la manera mas simple
        Collections.sort(list, (a, b) -> a.compareTo(b));
        
        System.out.println(list);
    }
    
    public static void main(String[] args) {
        SimpleComparatorExample();
        LambdaComparator();
    }
}
