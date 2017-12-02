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
    public void printSomething(String something, Printer printer)
    {
        printer.print(something);
    }
    
    public static void usingLambda1()
    {
        String header = "Simple use Lambda # 1";
        SimpleExample.printHeader(header);
        
        LambdaDemo1 demo1 = new LambdaDemo1();
        String message = "I am learning Lambda";
        Printer printer = (String toPrint) -> {System.out.println(toPrint);};
        demo1.printSomething(message, printer);
        
        // otras formas mas consisas del uso de lambda
        // Printer printer = (toPrint) -> {System.out.println(somethign);};
        // Printer printer = toPrint -> System.out.println(something);
    }
    
    public static void usingLambda2()
    {
        String header = "Simple use Lambda #2";
        SimpleExample.printHeader(header);
        LambdaDemo1 demo2 = new LambdaDemo1();
        String message = "I am Lambda";
        demo2.printSomething(message, (toPrint) -> {System.out.println(toPrint);});
    }
    
    public static void main(String[] args) {
        usingLambda1();
        usingLambda2();
    }
}
