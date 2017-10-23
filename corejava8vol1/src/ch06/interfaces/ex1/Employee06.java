/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.interfaces.ex1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jcva175
 */
public class Employee06 implements Comparable<Employee06>, Cloneable
{
    private String name;
    private int id;
    private static int nextId = 1;
    private double salary;
    private LocalDate hireDay;
    
    public Employee06()
    {
        this.name = "";
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }
    
    public Employee06(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    
    public Employee06(String name)
    {
        this.name = name;
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }
    
    public Employee06(double s)
    {
        this("Employee #: " + nextId, s);
        nextId++;
    }
    
    public Employee06(String name, double salary, int year, int month, int day)
    {
        this.name = name;
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
    
    public String getDescription()
    {
        return String.format("Empleado con un salario de $%.2f", salary);
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
    
    public void setHireDay(int year, int month, int day)
    {
        this.hireDay = LocalDate.of(year, month, day);
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
        
        Employee06 other = (Employee06) otherObject;
        
        return Objects.equals(salary, other.salary) && 
                Objects.equals(hireDay, other.hireDay);
    }
    
    /**
     * Compara empleados por el salario
     * @param other otro objecto Employee06 
     * @return un valor negativo si este empleado tiene un salario menor al parametro employee06,
     * retorna 0, si ambos tienen el mismo salario, un valor positivo si este empleado tiene un
     * salario mayor.
     */
    public int compareTo(Employee06 other)
    {
        return Double.compare(salary, salary);
    }
    
    @Override
    public Employee06 clone() throws CloneNotSupportedException
    {
        // llama Object.clone()
        Employee06 cloned = (Employee06) super.clone();
        
        // clonamos campos mutables
        
        return cloned;
    }
    
    public int hashCode()
    {
        return Objects.hash(id, name, salary, hireDay);
    }
    
    public String toString()
    {
        return " name= " + name + " salary= " + salary + " hireDate = " + hireDay;
    }
}
