/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import java.util.Arrays;

/**
 *
 * @author barcvilla
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        // recorrer una lista de numeros en versiones anteriores en Java
        System.out.println("Iteracion de una lista version anterior de java");
        for(Integer number : Arrays.asList(1,2,3,4,5,6,7,8,9,10))
        {
            System.out.print("Numero: " + number + " ");
        }
        System.out.println("");
        
        //Recoorer una lista de numeros utilizando expresiones Lambda en Java
        System.out.println("Iteracion de una lista utilizando expresiones Lambda");
        Arrays.asList(1,2,3,4,5,6,7,8,9,10).forEach(
            n -> System.out.print(n + " "));
        
        System.out.println("");
        // otra forma de utilizar expresiones lambda
        System.out.println("Otra forma de utilizar expresiones Lambda");
        Arrays.asList(1,2,3,4,5,6,7,8,9,10).forEach(System.out::print);
        System.out.println("");
    }
}
