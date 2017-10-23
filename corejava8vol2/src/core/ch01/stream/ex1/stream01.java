/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.ex1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcva175
 */
public class stream01 {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("./rs/alice.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split(","));
            long count;
            // Version SE8
            // Flujo cuando se trabaja con Stream
            // 1. Creamos un Stream
            System.out.println("Stream SE8");
            count = words.stream()
                    // 2. Especificamos operaciones intermedias para transformar el stream inicial en otros
                    // retrona un nuevo stream con elementos cuya longitud sea mayor 2
                    .filter(w -> w.length()> 2) 
                    // 3. Aplicamos operaciones de terminal para producir un resultado.
                    .count();
            System.out.println(count);
            
            System.out.println("Stream S8 usando ParallelStream");
            count = words.parallelStream()
                    .filter(w -> w.length() > 2)
                    .count();
            System.out.println(count);
            
            // Version SE7 y posteriores
            System.out.println("Stream SE7 y anteriores");
            count = 0;
            for(String w : words)
            {
                if(w.length() > 2)
                {
                    count++;
                }
            }
            System.out.println(count);
            
        } catch (IOException ex) {
            Logger.getLogger(stream01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
