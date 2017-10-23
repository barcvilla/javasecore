/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.inherencia.ex1;

import ch05.abstracts.ex1.Employee05;
import java.util.Objects;

/**
 *
 * @author jcva175
 */
public class Manager extends Employee05{
    private double bonus;
    
    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
        bonus = 0;
    }
    
    public Manager(String name, double salary, int year, int month, int day, double bonus)
    {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }
    
    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }
    
    @Override
    public double getSalary()
    {
        return super.getSalary() + bonus;
    }
    
    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject))
        {
            return false;
        }
        
        Manager other = (Manager) otherObject;
        
        return Objects.equals(bonus, other.bonus);
    }
    
    public int hashCode()
    {
        return super.hashCode() + Objects.hash(bonus);
    }
    
    public String toString()
    {
        return super.toString() + " Bonus = " +  bonus;
    }
}
