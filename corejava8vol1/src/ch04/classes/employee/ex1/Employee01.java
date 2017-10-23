/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.employee.ex1;

import java.time.LocalDate;

/**
 *
 * @author jcva175
 */
public class Employee01 {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee01(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercentage)
    {
        this.salary = salary + (salary * (byPercentage /100));
    }    
}
