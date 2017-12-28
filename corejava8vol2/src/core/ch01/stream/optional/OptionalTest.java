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
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class OptionalTest 
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
    
    public static void demoOptionalValue(List<String> value)
    {
        printHeader("Working with Optional Value");
        Optional<String> optionalValue = value.stream()
                .filter(s -> s.contains("PEDRO"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains PEDRO");
    }
    
    public static void demoOptionalString()
    {
        printHeader("Working with Optional String");
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        
        System.out.println("result: " + result);
        
        try
        {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
    }
    
    public static void demoOptionalValueIfPresent(List<String> value)
    {
        printHeader("Working with Optional Value If Present");
        Optional<String> optionalValues = value.stream()
                .filter(s -> s.contains("UNO"))
                .findFirst();
        optionalValues.ifPresent(s -> System.out.println(s + " contains UNO"));
        
        Set<String> results = new HashSet<>();
        optionalValues.ifPresent(results::add);
        Optional<Boolean> added = optionalValues.map(results::add);
        
        System.out.println(added);
    }
    
    public static Optional<Double> inverse(Double x)
    {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }
    
    public static Optional<Double> squareRoot(Double x)
    {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
    
    public static void main(String[] args) {
        String contents = readFile("alice");
        List<String> wordList = Arrays.asList(contents.split(","));
        
        demoOptionalString();
        demoOptionalValue(wordList);
        demoOptionalValueIfPresent(wordList);
        
        printHeader("Creando Optional Values");
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        
        printHeader("Composing funcion OptionalValue con flatMap");
        Optional<Double> result2 = Optional.of(-4.0)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);
    }
}
