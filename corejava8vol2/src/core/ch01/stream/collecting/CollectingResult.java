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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
        System.out.println("[" + set.stream().map(Object::toString)
        .collect(Collectors.joining(", ")) + "]");
    }
    
    public static void main(String[] args) {
        Set<String> numbers = readFile()
                .collect(Collectors.toSet());
        show("Reading file", numbers);
    }
}
