/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.employee.ex2;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author jcva175
 */
public class Employee02 {
    private int id;
    private static int nextId = 1;
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee02()
    {
        this.name = "";
        this.salary = 0;
        this.hireDay = LocalDate.now();
    }
    
    public Employee02(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    
    public Employee02(double s)
    {
        this("Employee #: " + nextId, s);
        nextId++;
    }
    
    public Employee02(String name, double salary, int year, int month, int day)
    {
        setName(name);
        setSalary(salary);
        setHireDay(LocalDate.of(year, month, day));
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
    
    
    
    public static int getNextId()
    {
        return nextId;
    }
    
    public int getId()
    {
        return id;
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
        return getName() + " " + getSalary() + " " + getHireDay();
    }
}
