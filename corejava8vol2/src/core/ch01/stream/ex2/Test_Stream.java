/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.ex2;

import core.ch01.stream.ex1.stream01;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        iterarStream(randoms);
    }
    
    public static void demoStreamSkip()
    {
        String fileSource = readFile("skip_text");
        Stream<String> words = Stream.of(fileSource.split("\\PL+")).skip(1);
        iterarStream(words);
    }
    
    public static void main(String[] args) 
    {
        demoExtractingSubStream();
        demoStreamSkip();
    }
}
