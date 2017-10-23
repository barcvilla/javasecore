/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.inherencia.ex1;

import ch05.abstracts.ex1.Employee05;

/**
 *
 * @author jcva175
 */
public class ManagerTest {
    public static void main(String[] args)
    {
        Manager boss = new Manager("Carl Hacker", 1000, 1980, 10, 11);
        boss.setBonus(250);
        
        Employee05[] staff = new Employee05[3];
        staff[0] = boss;
        staff[1] = new Employee05("Harry Cracker", 1200, 1972, 11, 10);
        staff[2] = new Employee05("Tommy Tester", 1400, 1970, 9, 20);
        
        for(Employee05 emp : staff)
        {
            System.out.println("name= " + emp.getName() + " salary = " + emp.getSalary());
        }
    }
}
