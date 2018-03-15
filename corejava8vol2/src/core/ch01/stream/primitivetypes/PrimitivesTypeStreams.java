/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.primitivetypes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * La biblioteca Stream tiene tipos especializados IntStream, LongStream, DoubleStream que almacena valores primitivos
 * directamente  si utilizar wrappers. Si queremos almacenar short, char, byte y boolean usamos IntStream y para
 * float usamo DoubleStream.
 * @author barcvilla
 */
public class PrimitivesTypeStreams 
{
    public static void show(String title, IntStream stream)
    {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.println(title + ": ");
        for(int i = 0; i < firstElements.length; i++)
        {
            if(i > 0)
            {
                System.out.print(firstElements[i]);
            }
            if(i < SIZE)
            {
                System.out.print(firstElements[i]);
            }
            else
            {
                System.out.println("...");
            }
        }
        System.out.println();
    }
    
    public static void primitiveStreamDemo()
    {
        // creamos una instancia de IntStream y generamos un rango de integers
        IntStream is1 = IntStream.generate(() -> (int)(Math.random() * 100));
        show("is1", is1);
        
        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);
        
        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);
    }
    
    public static String readFile(String fileName)
    {
        String contents = "";
        try
        {
            contents = new String(Files.readAllBytes(Paths.get("./rs/" + fileName + ".txt")), StandardCharsets.UTF_8);
        }
        catch(IOException ex)
        {
            Logger.getLogger(PrimitivesTypeStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }
    
    public static void primiteStream()
    {
        String contents = readFile("alice");
        Stream<String> words = Stream.of(contents.split("\\PL+")); 
        /* cuando tenemos un stream de objetos, podemos transformarlos en un stream de tipos primitivos con
           mapToInt, mapToLong, mapToDouble*/
        IntStream is4 = words.mapToInt(String::length); //procesamos length de un stream string como entero.
        show("is4", is4);
        String sentence = "\uD835\uDD46 is the set of octonions";
        System.out.print(sentence);
        
        IntStream codes = sentence.codePoints();
        System.out.print(codes.mapToObj(c -> String.format("%X", c)).collect(Collectors.joining()));
        // convertimos un stream type primitive en un stream object
        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5", is5);
    }
    
    public static void main(String[] args)
    {
        primitiveStreamDemo();
        primiteStream();
    }
}
