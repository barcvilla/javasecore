/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.abstracts.ex1;

/**
 *
 * @author jcva175
 */
public class PersonTest {
    public static void main(String[] args)
    {
        Person[] people = new Person[2];
        people[0] = new Employee05("Harry Hacker", 1000, 1980, 11, 20);
        people[1] = new Student("Maria Morris", "Computer Science");
        
        for(Person p : people)
        {
            System.out.println("Nombre: " + p.getName() + " Descripcion: " + p.getDescription());
        }
    }
}
