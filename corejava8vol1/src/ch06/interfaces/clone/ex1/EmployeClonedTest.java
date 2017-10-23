/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.interfaces.clone.ex1;

import ch06.interfaces.ex1.Employee06;

/**
 *
 * @author jcva175
 */
public class EmployeClonedTest {
    public static void main(String[] args) {
        try
        {
            Employee06 original = new Employee06("John Q.", 50000, 1980, 10, 26);
            Employee06 copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(1981, 11, 27);
            
            System.out.println("original = " + original);
            System.out.println("copy = " + copy);
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
