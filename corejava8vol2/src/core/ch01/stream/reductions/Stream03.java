/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.reductions;

import core.ch01.stream.creations.stream01;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream Simple Reductions : nos permiten obtener datos de los streams. Reductions son terminal operations. Ellos
 * reducen el stream a un valor non-stream que pueden ser usado en nuestro programa.
 * @author barcvilla
 */
public class Stream03 
{
    public static void printHeader(String header)
    {
        System.out.println("\n======================================");
        System.out.println(header);
        System.out.println("\n======================================");
    }
    public static String readFile(String file)
    {
        String contents = "";
        try
        {
            contents = new String(Files.readAllBytes(Paths.get("./rs/" + file + ".txt")), StandardCharsets.UTF_8);
        }
        catch(IOException ex)
        {
            Logger.getLogger(stream01.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }
    
    public static <T> void iterarStream(Stream<T> stream)
    {
        List<T> elements = stream.collect(Collectors.toList());
        for(int i = 0; i < elements.size(); i++)
        {
            System.out.println("# '" + i + "' " + elements.get(i));
        }
    }
    
    /**
     * Simples operaciones de reduccion como min y max que retorna el mayor o menos valor. estos metodos retornan un
     * valor Optional<T> que envuelve la respuesta o indica que no hay(que significa que el stream es empty)
     */
    public static void demoReturnLargestValueFromStream()
    {
        String header = "Getting largest elemento from a Strema objet";
        printHeader(header);
        Stream<String> words = Stream.of("Diego", "Nicolas", "Fernando", "Alan", "Carlos");
        Optional<String> largest = words.max(String::compareToIgnoreCase);
        System.out.println("Largest elemento: " + largest.orElse(""));
    }
    
    /**
     * findFirst() retorna el primer valor que ocurre en una collection nonempty. Este metodo es util cuando lo
     * combinamos con filter(). En este demo encontramos la primera palabra que empiece con la letra C si existe
     */
    public static void demoFindFirst()
    {
        String header = "Encuentra el primer elemento que inicie con la letra 'C'";
        printHeader(header);
        Stream<String> words = Stream.of("Diego", "Nicolas", "Fernando", "Alan", "Carlos", "Nolberto");
        
        Optional<String> startWithC = words.filter(s -> s.startsWith("C")).findFirst();
        System.out.println("Primer elemento con la letra C: " + startWithC.get());
        
    }
    
    public static void demoFindAny()
    {
        String header = "Encuentra el primer elemento que inicie con la letra 'N'";
        printHeader(header);
        Stream<String> words = Stream.of("Diego", "Nicolas", "Fernando", "Alan", "Carlos", "Nolberto");
        Optional<String> findAnyWith = words.filter(s -> s.startsWith("N")).findAny();
        System.out.println("Encontrar cualquier elemento que coincida con la letra N: " + findAnyWith.get());
    }
    
    public static void main(String[] args) 
    {
        demoReturnLargestValueFromStream();
        demoFindFirst();
        demoFindAny();
    }
}
