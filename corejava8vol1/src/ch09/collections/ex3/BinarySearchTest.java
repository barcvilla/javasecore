/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex3;

import ch06.interfaces.ex1.Employee06;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author barcvilla
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        List<Employee06> staff = new LinkedList<>();
        staff.add(new Employee06("Fernando", 11000));
        staff.add(new Employee06("Manuel", 6894));
        staff.add(new Employee06("Antonio", 20100));
        
        int index = Collections.binarySearch(staff, new Employee06("Manuel", 6894));
        System.out.println("Encontrado en el indice: " + index);
        
        // binarySearch pasando un objeto comparator
        Comparator<Employee06> cmp = new Comparator<Employee06>() {
            @Override
            public int compare(Employee06 o1, Employee06 o2) 
            {
                return o1.getName().compareTo(o2.getName());
            }
        }; 
        
        index = Collections.binarySearch(staff, new Employee06("Fernando", 11000), cmp);
        System.out.println("Empleado encontrado en el indice: " + index);
    }
}
