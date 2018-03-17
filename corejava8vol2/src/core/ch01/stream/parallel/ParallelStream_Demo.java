/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.parallel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class ParallelStream_Demo {
    
    public static String readFile(String fileName)
    {
        String contents = "";
        try
        {
            contents = new String(Files.readAllBytes(Paths.get("./rs/" + fileName + ".txt")), StandardCharsets.UTF_8);
            
        }
        catch(IOException ex)
        {
            Logger.getLogger(ParallelStream_Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }
        
    // Very bad code ahead
    public static void processingStream()
    {
       String contents = readFile("alice");
       List<String> wordList = Arrays.asList(contents.split("\\PL+"));
       int[] shortWords  = new int[10];
       wordList.parallelStream().forEach(s ->
       {
           if(s.length() < 10)
           {
               shortWords[s.length()]++;
           }
       });
        System.out.println(Arrays.toString(shortWords));
    }
    
    // nuevo intento-- el resulto sera algo distinto (pero tambien errado)
    public static void processingStream2()
    {
        String contents = readFile("distinct_text");
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        int[] shortWords = new int[10];
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s ->
        {
            if(s.length() < 10)
            {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));
    }
    
    // Remedio : Agrupacion y conteo
    public static void processingStream3()
    {
        String contents = readFile("countries");
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Map<Integer, Long> shortWordsCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(shortWordsCounts);
    }
    
    // Downstream order not deterministic
    public static void processingStream4()
    {
        String contents = readFile("countries");
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Map<Integer, List<String>> result = wordList.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));
        
    }
    
    public static void processingStream5()
    {
        String contents = readFile("countries");
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Map<Integer, Long> wordCounts = wordList.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        System.out.println(wordCounts);
    }
    
    public static void main(String[] args) {
        processingStream();
        processingStream2();
        processingStream3();
        processingStream4();
        processingStream5();
    }
}
