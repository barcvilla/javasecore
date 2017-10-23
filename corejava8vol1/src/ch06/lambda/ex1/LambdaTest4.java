/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author barcvilla
 */
public class LambdaTest4 {
    public static void main(String[] args) {
        ArrayList<Integer> mayores = (ArrayList<Integer>) Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                // creamos el strema
                .stream()
                // filtramos para obtener los numero mayores a 5 y usamos expresion lambda
                .filter(x -> x > 5)
                // colocamos los elementos filtrados en una nueva lista
                .collect(Collectors.toCollection(() -> new ArrayList<Integer>()));
        mayores.forEach(e -> System.out.println(e));
        
    }
}
