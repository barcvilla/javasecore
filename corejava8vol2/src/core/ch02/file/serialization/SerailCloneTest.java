/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.serialization;

/**
 *
 * @author PC
 */
public class SerailCloneTest {
    public static void main(String[] args)throws CloneNotSupportedException {
        EmployeeSerial harry = new EmployeeSerial("Harry Hacker", 35000, 1989, 10, 1);
        
        /*Clone harry*/
        EmployeeSerial harry2 = (EmployeeSerial) harry.clone();
        
        /*mutate harry*/
        harry.raiseSalary(10);
        
        /*ahora harry y el clon son diferente*/
        System.out.println(harry);
        System.out.println(harry2);
    }
}
