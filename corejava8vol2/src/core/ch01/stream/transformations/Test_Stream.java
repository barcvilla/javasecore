/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.transformations;

import core.ch01.stream.creations.stream01;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class Test_Stream 
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
     * Stream.limit(n) retorna un nuevo stream que termina despues de n elementos
     */
    public static void demoExtractingSubStream()
    {
        String header = "Extracting a SubStream from a Stream";
        printHeader(header);
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        iterarStream(randoms);
    }
    
    public static void demoStreamSkip()
    {
        String header = "Apply skip element from a Stream";
        printHeader(header);
        String fileSource = readFile("skip_text");
        Stream<String> words = Stream.of(fileSource.split("\\PL+")).skip(1);
        iterarStream(words);
    }
    
    /**
     * El metodo distinct retorna los elementos del stream original en el mismo orden pero los duplicados son removidos
     */
    public static void demoStreamDistinct()
    {
        String header = "Applying distinct operation in a Stream";
        printHeader(header);
        String in = readFile("distinct_text");
        Stream<String> contents = Stream.of(in).distinct();
        iterarStream(contents);
    }
    
    /**
     * Como con todas las transformaciones de Stream, el metodo sorted genera un nuevo stream cuyo elementos son
     * los elementos del stream original ordenados.
     */
    public static void demoSortedStreamLongestFirst()
    {
        String header = "Sorting a stream element with the mayor lenght first";
        printHeader(header);
        Stream<String> words = Stream.of("Diego", "Nicolas", "Fernando", "Paul", "Alan", "Carlos");
        Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
        iterarStream(longestFirst);
    }
    
    public static void main(String[] args) 
    {
        demoExtractingSubStream();
        demoStreamSkip();
        demoStreamDistinct();
        demoSortedStreamLongestFirst();
    }
}
