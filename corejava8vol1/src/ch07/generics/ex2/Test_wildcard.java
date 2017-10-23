/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.generics.ex2;

import ch05.abstracts.ex1.Employee05;
import ch05.inherencia.ex1.Manager;
import ch07.generics.ex1.Pair;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author barcvilla
 */
public class Test_wildcard {
    public static void main(String[] args) {
        List<Manager> emp = new ArrayList<>();
        
        emp.add(new Manager("Juan Gomez", 50000, 1980, 10, 22));
        emp.add(new Manager("Pedro Quiroga", 55000, 1985, 5, 15));
        
        Pair<Manager> mm = new Pair<Manager>();
        mm.setFirst(emp.get(0));
        mm.setSecond(emp.get(1));
        
        printBuddies(mm);
        
        System.out.println("SwapHelper");
        swapHelper(mm);
    }
    
    public static void printBuddies(Pair<? extends Employee05> p)
    {
        Employee05 first = p.getFirst();
        Employee05 second = p.getSecond();
        
        System.out.println(first.getName() + " and " + second.getName() +  " are buddies");
    }
    
    // El parametro T captura el Wildcard
    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
        Manager first = (Manager) p.getFirst();
        Manager second = (Manager)p.getSecond();
        
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }
}
