/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.abstracts.ex1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jcva175
 */
public class Employee05 extends Person{
    private int id;
    private static int nextId = 1;
    private double salary;
    private LocalDate hireDay;

    public Employee05()
    {
        super("");
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }
    
    public Employee05(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }
    
    public Employee05(double s)
    {
        this("Employee #: " + nextId, s);
        nextId++;
    }
    
    public Employee05(String name, double salary, int year, int month, int day)
    {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }
    
    //bloque de inicializacion static
    static
    {
        Random generator = new Random();
        // set nextId un numero random entre 0 y 999
        nextId = generator.nextInt(10000);
    }
    
    // bloque de inicializacion de objeto
    {
        id = nextId;
        nextId++;
    }

    public static int getNextId()
    {
        return nextId;
    }
    
    public int getId()
    {
        return id;
    }
    
    @Override
    public String getDescription()
    {
        return String.format("Empleado con un salario de $%.2f", salary);
    }
    
    public String getName() {
        return super.getName();
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
    public boolean equals(Object otherObject)
    {       
        if(!super.equals(otherObject))
        {
            return false;
        }
        
        Employee05 other = (Employee05) otherObject;
        
        return Objects.equals(salary, other.salary) && 
                Objects.equals(hireDay, other.hireDay);
    }
  
    public int hashCode()
    {
        return super.hashCode() + Objects.hash(id, salary, hireDay);
    }
    
    public String toString()
    {
        return super.toString() + " salary= " + salary + " hireDate = " + hireDay;
    }
}
