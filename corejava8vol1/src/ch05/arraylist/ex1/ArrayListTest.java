/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.arraylist.ex1;

import java.util.*;
import ch05.abstracts.ex1.Employee05;

/**
 *
 * @author jcva175
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee05> staff = new ArrayList<>();
        
        staff.add(new Employee05("Carl Cracker", 50000, 1980, 10, 22));
        staff.add(new Employee05("Harry Cracker", 50000, 1980, 10, 22));
        staff.add(new Employee05("John Cracker", 50000, 1980, 10, 22));
        
        // subimos un 5% el salario
        for(Employee05 e : staff)
        {
            e.raiseSalary(5);
        }
        
        // impresion de la informacion
        
        for(Employee05 e : staff)
        {
            System.out.println(e.toString());
        }
    }
}
