/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.emun.ex1;

import java.util.Scanner;

/**
 *
 * @author jcva175
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size = " + size);
        System.out.println("Abreviacion = " + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
        {
            System.out.println("Para la mano con...");
        }
    }
}
