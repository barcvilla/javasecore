/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.serialization;

import core.ch02.file.write.Employee;

/**
 *
 * @author PC
 */
public class Manager extends Employee
{
    private Employee secretary;
    
    public Manager(){}
    
    public Manager(String name, double salary, int year, int month, int day)
    {
        super(name, salary, year, month, day);
    }
    
    public void setSecretary(Employee e)
    {
        this.secretary = e;
    }
}
