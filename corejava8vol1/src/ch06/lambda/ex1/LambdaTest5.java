/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

/**
 *
 * @author barcvilla
 */
public class LambdaTest5 {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        
        // se implementa el metodo de la interface con una expresion lambda
        IFunctionalLambda ifLambda = (a, b) ->
        {
            System.out.println(a + b);
        };
        
        // se utiliza el metodo con la implementacion y se le envia los valores de x e y
        ifLambda.suma(x, y);
    }
}
