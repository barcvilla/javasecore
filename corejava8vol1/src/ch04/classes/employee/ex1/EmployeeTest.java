/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.employee.ex1;

/**
 *
 * @author jcva175
 */
public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee01[] staff = new Employee01[3];
        staff[0] = new Employee01("Juan Gonzalez", 50000, 1982, 10, 20);
        staff[1] = new Employee01("Mario Peralta", 12000, 1979, 10, 20);
        staff[2] = new Employee01("Rosa Guzman", 25000, 1991, 10, 20);

        for(Employee01 employees : staff)
        {
            employees.raiseSalary(15);
        }

        for(Employee01 employees : staff)
        {
            System.out.println("Name: " + employees.getName() + " Salary: " + employees.getSalary() + " Hire Day: " + employees.getHireDay());
        }
    }    
}
