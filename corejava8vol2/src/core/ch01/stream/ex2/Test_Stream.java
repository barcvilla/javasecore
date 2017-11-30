/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.ex2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class Test_Stream 
{
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
    
    public static void main(String[] args) 
    {
        demoExtractingSubStream();
    }
}
