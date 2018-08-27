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
public class StringConcatenationDemo {
    
    private static void stringConcat()
    {
        String s = "hello" + "world!";
        System.out.println(s);
        
        StringBuffer sb = new StringBuffer(s);
        sb.append(" good").append(" morning");
        System.out.println("sb: " + sb.toString());
        System.out.println("sb.length: " + sb.length());
        
        sb.delete(1, 5); //index 5 se excluye
        System.out.println("sb: " + sb.toString());
        System.out.println("sb.length: " + sb.length());
        
        sb.insert(1, "ey");
        System.out.println("sb: " + sb.toString());
        System.out.println("sb.length: " + sb.length());
    }
    
    public static void main(String[] args) {
        stringConcat();
    }
}
