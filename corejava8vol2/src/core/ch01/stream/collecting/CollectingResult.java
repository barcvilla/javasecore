/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.collecting;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cuando hacemos cosas con stream, a menudo queremos ver sus elemento.
 * @author barcvilla
 */
public class CollectingResult 
{
    public static Stream<String> readFile()
    {
        Stream<String> numbers = null;
        try
        {
            String contents = new String(Files.readAllBytes(Paths.get("./rs/1Kints.txt")), StandardCharsets.UTF_8);
            List<String> numbersList = Arrays.asList(contents.split("\\."));
            numbers = numbersList.stream();
        }
        catch(IOException ex)
        {
            Logger.getLogger(CollectingResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numbers;
    }
    
    public static <T> void show(String label, Set<T> set)
    {
        System.out.println(label + ": " + set.getClass().getName());
        // Los objetos en el stream no son String, asi que los convertirmos a String
        System.out.println("[" + set.stream().map(Object::toString)
        // concatenamos los elementos de un stream mas un delimitador ", "
        .collect(Collectors.joining(", ")) + "]"); 
    }
    
    public static void printReadFileDemo()
    {
        Set<String> numbers = readFile()
                // collect stream elements to another target. Collectors provee varios factory methods
                // para obtener Collection comunes. Collectors.toSet() / Collectors.toList()
                // TreeSet<String> result = stream.collect(Collectors.toCollection(TreeSet::new));
                .collect(Collectors.toSet());
        show("Reading file ", numbers);
    }
    
    public static void iteratingElementsDemo()
    {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10)
                .iterator();
        while(iter.hasNext())
        {
            System.out.print(iter.next());
        }
        System.out.println("");
    }
    
    public static void interatingIntegerDemo()
    {
        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object Array: " + numbers); // notar es un array object
        try
        {
            Integer number = (Integer) numbers[0];
            System.out.println("Number: " +  number);
            System.out.println("La siguiente sentencia lanzara una exception: ");
            Integer[] numbers2 = (Integer[]) numbers;
        }
        catch(ClassCastException ex)
        {
            System.out.println(ex);
        }
    }
    
    public static void integerArrayDemo()
    {
        Integer[] number3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        Integer number4 = (Integer) number3[0];
        System.out.print("Integer array: " + number4);
        System.out.println("");
    }
    
    public static void main(String[] args) {
        printReadFileDemo();
        iteratingElementsDemo();
        interatingIntegerDemo();
        integerArrayDemo();
    }
}
