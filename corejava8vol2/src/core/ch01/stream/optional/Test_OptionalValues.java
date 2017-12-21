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
import java.util.Locale;
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
    
    public static void demoUsingOptionalWhenNoElementInStream()
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
         * Podemos usar invocar un codigo que se calcule como default con el metodo orElseGet()
         * Podemos tambien lanzar una excepcion si no hay un valor: orElseThrow(IllegalStateException::new)
         */
        System.out.println(optionalValue.orElse("NO NUMBER") + " contains VEINTE");
    }
    
    public static void demoUsingOptionalInvokingPieceOfCode()
    {
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("reslt: " + result);
        try
        {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Creando valores Optional
     * @param x Double value
     * @return Valor creado por un objeto Optional. Hay muchos metodos static para este proposito incluyendo:
     * Optional.of(result)
     * Optional.empty()
     */
    public static void demoInverse(Double x)
    {
        System.out.println(x == 0 ? Optional.empty() : Optional.of(1 / x));
    }
    
    public static void main(String[] args) 
    {
        demoUsingOptionalWhenNoElementInStream();
        demoUsingOptionalInvokingPieceOfCode();
        demoInverse(0.2);
    }
}
