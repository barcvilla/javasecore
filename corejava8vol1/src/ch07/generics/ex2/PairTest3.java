/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.generics.ex2;

import ch05.inherencia.ex1.Manager;
import ch07.generics.ex1.Pair;
import ch05.abstracts.ex1.Employee05;
/**
 *
 * @author barcvilla
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 90000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 60000, 2003, 12, 15);
        
        Pair<Manager> buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);
        
        Manager[] managers = {ceo, cfo};
        Pair<Employee05> result = new Pair<Employee05>();
        minmaxSalary(managers, result);
        System.out.println("First: " + result.getFirst().getName() + " Second: " + result.getSecond().getName());
        
        maxminSalary(managers, result);
        System.out.println("First: " + result.getFirst().getName() + " Second: " + result.getSecond().getName());
    }
    
    public static void printBuddies(Pair<? extends Employee05> p)
    {
        Employee05 first = p.getFirst();
        Employee05 second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName());
    }
    
    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result)
    {
        if(a.length == 0)
        {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        
        for(int i = 1; i < a.length; i++)
        {
            if(min.getSalary() > a[i].getSalary())
            {
                min = a[i];
            }
            
            if(min.getSalary() < a[i].getSalary())
            {
                max = a[i];
            }
            result.setFirst(min);
            result.setSecond(max);
        }
    }
    
    public static void maxminSalary(Manager[] a, Pair<? super Manager> result)
    {
        minmaxSalary(a, result);
        PairAlg.swapHelper(result); //ok.. swapHelper captura el wildcard type
    }
}

class PairAlg
{
    public static boolean hasNull(Pair<?> p)
    {
        if(p.getFirst() == null || p.getSecond() == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
