/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.write;

import java.time.LocalDate;

/**
 *
 * @author jcva175
 */
public class Employee {
    
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
    
    private String name;
    private double salary;
    private LocalDate hireDay;
    
    public Employee(){}

    public Employee(String name, double salary, int year, int month, int day)
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
    
    @Override
    public String toString()
    {
        return "Name: " + getName() + " Salary: " + getSalary() + " HireDate: " + getHireDay();
    }
}
