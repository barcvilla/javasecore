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
public class StringPoolDemo {
    
    private static void stringPool()
    {
        System.out.println("\nInside stringPool...");
        String s1 = "hello!";
        String s2 = "hello!";
        String s3 = "hello!".intern();
        String s4 = new String("hello!");
        String s5 = "lo!";
        
        System.out.println("s1==s2: " + (s1==s2));
        System.out.println("s1==s3: " + (s1==s2));
        System.out.println("s1==s4: " +  (s1==s4));
        System.out.println("s1==s4.intern(): " + (s1 == s4.intern()));
        System.out.println("s1==\"hel\" + \"lo!\": " + (s1=="hel" + "lo!"));
        System.out.println("s1==\"hel\" + s5: " + (s1=="hel" + s5));
    }
    
    public static void main(String[] args) {
        stringPool();
    }
}
