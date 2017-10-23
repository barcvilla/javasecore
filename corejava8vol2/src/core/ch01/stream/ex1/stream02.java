/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.ex1;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 * @author jcva175
 */
public class stream02 {
    public static <T> void show(String title, Stream<T> stream)
    {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(title + ": ");
        for(int i = 0; i < firstElements.size(); i++)
        {
            if(i > 0) System.out.println(", ");
            if(i < SIZE) System.out.println(firstElements.get(i));
            else System.out.println("...");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException 
    {
        Path path = Paths.get("./rs/alice.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split(","));
        show("Words", words);
        
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("Song", song);
        
        Stream<String> silence = Stream.empty();
        show("silence", silence);
        
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("Echo", echos);
        
        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);
        
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);
        
        Stream<String> wordsAnotherWay = Pattern.compile(",").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);
        
        try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8))
        {
            show("Lines", lines);
        }
    }
}
