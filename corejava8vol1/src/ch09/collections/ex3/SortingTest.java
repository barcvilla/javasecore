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
public class SortingTest 
{
    public static void main(String[] args) {
        List<Employee06> staff = new LinkedList<>();
        staff.add(new Employee06("Juan Antonio", 60000));
        staff.add(new Employee06("Pedro Manuel", 20000));
        staff.add(new Employee06("Fernando", 12000));
        staff.add(new Employee06("Jose", 11678));
        // usamos el metodo sort de la clase Collections que implementa la interface List
        Collections.sort(staff);
        
        // Ordenamos la lista de empleados por el salario
        staff.sort(Comparator.comparingDouble(Employee06::getSalary));
        for(Employee06 emp : staff)
        {
            System.out.println(emp);
        }
        
        // Ordenamos la lista en orden reverso -  salario descendente.
        staff.sort(Comparator.comparingDouble(Employee06::getSalary).reversed());
        
    }
}
