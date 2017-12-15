/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.optional;

import core.ch01.stream.creations.stream01;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class Test_OptionalValues 
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
    
    public static void demoUsingOptionalValue()
    {
        String header = "Working with Optional<T>";
        printHeader(header);
        String content = readFile("alice");
        List<String> wordList = Arrays.asList(content.split(","));
        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("VEINTE"))
                .findFirst();
        /**
         * 1era estrategia usando Optional Value
         * Hay un valor default que queremos usar cuando no hay coincidencia, quizas un string empty
         */
        System.out.println(optionalValue.orElse("NO NUMBER") + " contains VEINTE");
    }
    
    public static void main(String[] args) 
    {
        demoUsingOptionalValue();
    }
}
