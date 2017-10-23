/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.employee.ex2;

import java.text.NumberFormat;

/**
 *
 * @author jcva175
 */
public class EmployeeStaticTest {
    public static void main(String[] args)
    {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        Employee02[] staff = new Employee02[3];
        staff[0] = new Employee02("Juan", 1000, 1980, 10, 23);
        staff[1] = new Employee02("Pedro", 2000, 1985, 9, 20);
        staff[2] = new Employee02("Maria", 3000, 1982, 7, 20);
        
        for(Employee02 emp : staff)
        {
            System.out.println("Id: " + emp.getId() + " name: " + emp.getName() + 
                    " salary: " + currencyFormatter.format(emp.getSalary()));
        }
    }
    
    
}
