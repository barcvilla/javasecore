/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.expressions;

/**
 * Las expresiones Lambda son usadas principalmente para definir implementaciones en linea de una interface funcional.
 * @author barcvilla
 */
public class LambdaDemo1 {
    
    public static void usingLambda1()
    {
        String header = "Simple use Lambda";
        ClassicSample.printHeader(header);
        
        LambdaDemo1 demo1 = new LambdaDemo1();
        String something = "I am learning Lambda";
        Printer printer = (String toPrint) -> {System.out.println(something);};
        // otras formas mas consisas del uso de lambda
        // Printer printer = (toPrint) -> {System.out.println(somethign);};
        // Printer printer = toPrint -> System.out.println(something);
    }
    
    public static void main(String[] args) {
        usingLambda1();
    }
}
