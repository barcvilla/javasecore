/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author barcvilla
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        ArrayList<Integer> menos = new ArrayList<Integer>();
        for(Integer numero : Arrays.asList(1,2,3,4,5,6,7,8,9,10))
        {
            if(numero > 5)
            {
                menos.add(numero);
            }
        }
        // impresion de la lista
        for(Integer integers : menos)
        {
            System.out.print(menos + " ");
        }
    }
}
