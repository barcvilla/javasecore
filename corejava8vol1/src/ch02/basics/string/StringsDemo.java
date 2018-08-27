/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.basics.string;

/**
 *
 * @author PC
 */
public class StringsDemo {
    
    private static void stringExamples()
    {
        System.out.println("\nInside String Examples");
        String s = "hello world!";
        System.out.println("s: " + s);
        
        System.out.println("\ns.length(): " + s.length());
        System.out.println("s.isEmpty(): " + s.isEmpty());
    }
    
    private static void comparisonString()
    {
        String s = "hello world!";
        System.out.println("s: " + s);
        System.out.println("\ns.equals(\"HELLO WORLD!\"): " + s.equals("HELLO WORLD!"));
        System.out.println("s.equalsIgnoreCase(\"HELLO WORLD!\"): " + s.equalsIgnoreCase("HELLO WORLD!"));
        System.out.println("s.compareTo(\"HELLO WORLD!\"): " + s.compareTo("hello world!"));
    }
    
    private static void searchingString()
    {
        String s = "hello world!";
        System.out.println("s: " + s);
        System.out.println("\ns.contains(\"HELLO WORLD\"): " + s.contains("HELLO WORLD!"));
        System.out.println("s.contains(\"world!\"): " + s.contains("world!"));
        System.out.println("s.startsWith(\"HELLO WORLD!\"): " + s.startsWith("HELLO WORLD!"));
        System.out.println("s.startsWith(\"hello world!\"): " + s.startsWith("hello world!"));
        System.out.println("s.endsWith(\"!\"): " + s.endsWith("!"));
        System.out.println("s.indexOf(\"lo\"): " + s.indexOf("lo"));
        System.out.println("s.indexOf(\"o\"): " + s.indexOf("o"));
        System.out.println("s.lastIndexOf(\"o\"): " + s.lastIndexOf("o"));
    }
    
    private static void charactersAndSubstrings()
    {
        String s = "hello world!";
        System.out.println("s: " + s);
        System.out.println("\ns.charAt(4): " + s.charAt(4));
        
        //extraemos substring
        System.out.println("\ns.substring(4): " + s.substring(4));
        System.out.println("s.substring(4,9): " + s.substring(4,9)); //incluye desde character 4 y excluye character 9
    }
    
    private static void stringConversion()
    {
        String s = "hello world!";
        System.out.println("\ns.toUpperCase(): " + s.toUpperCase());
        System.out.println("s.toLowerCase(): " + s.toLowerCase());
        System.out.println("\ns.trim(): " + s.trim()); //string sin espacios en blanco derecha e izquierda
    }
    
    private static void replaceString()
    {
        String s = "hello world!";
        System.out.println("\ns.replaceAll(\"o\", \"n\"): " + s.replace("o", "r"));
        
        //Split
        System.out.println("\ns.split(\"o\"): ");
        String[] sa = s.split("o");
        for(String temp : sa)
        {
            System.out.println(temp);
        }
        
        //static method
        double n = 1.3;
        System.out.println("\nString.valueOf(1.3): " + String.valueOf(n));
    }
    
    public static void main(String[] args) {
        stringExamples();
        comparisonString();
        searchingString();
        searchingString();
        charactersAndSubstrings();
        stringConversion();
        replaceString();
    }
}
