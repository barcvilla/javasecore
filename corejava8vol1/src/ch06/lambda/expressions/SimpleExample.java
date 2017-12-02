/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.expressions;

/**
 *
 * @author barcvilla
 */
public class SimpleExample 
{
    public static void printHeader( String header)
    {
        System.out.println("\n" + "====================================");
        System.out.println(header);
        System.out.println("\n" + "====================================");
    }
    public void simplePrinting(String something)
    {
        System.out.println(something );
    }
    
    public void printSomething(String something, Printer printer)
    {
        printer.print(something);
    }
    
    /**
     * Estilo OOP clasico de ocultar la implementacion del metodo al llamador. El llamador simplemente pasa una
     * variable al metodo el cual hace algo con ese valor de la variable y retorna otro valor
    */
    public static void demoPrint()
    {
        String header = "Estilo clasico de OOP";
        printHeader("1  " + header);
        SimpleExample demo = new SimpleExample();
        String message = "I am learning Lambda";
        demo.simplePrinting(message);
    }
    
    public static void demoPrint1()
    {
        String header = "Aplicando implementacion de Printer";
        printHeader("2 " + header);
        SimpleExample demo = new SimpleExample();
        String something = "I am using a functional interface";
        
        Printer printer = new Printer()
        {
            @Override
            public void print(String val)
            {
                System.out.println(val);
            }
        };
        
        demo.printSomething(something, printer);
    }
    
    public static void main(String[] args) {
        
        demoPrint();
        demoPrint1();
    }
}
