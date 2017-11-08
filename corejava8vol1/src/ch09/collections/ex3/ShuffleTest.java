/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author barcvilla
 */
public class ShuffleTest
{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 49; i++)
        {
            numbers.add(i); // arraylist con 49 objetos desde 1 hasta 49
        }
        Collections.shuffle(numbers); // aleatoriamente mezclamos la lista de numeros.
        
        List<Integer> winningCombination = numbers.subList(0, 6); // seleccionams los primeros valores de la lista mezclada
        Collections.sort(winningCombination); // se ordenan los valores seleccionados 
        System.out.println(winningCombination);
    }
}
