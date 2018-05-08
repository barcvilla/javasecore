/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.serialization;

import core.ch02.file.write.Employee;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1) ;
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        
        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);
        
        Employee[] staff = new Employee[3];
        
        staff[0] = carl;
        staff[1] = harry;
        staff[1] = tony;
        
        /*Guardamos todos los registros de los empleados en el archivo employeeObject.dat*/
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employeeObject.dat")))
        {
            out.writeObject(staff);
        }
        
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("employeeObject.dat")))
        {
            /*recuperamos todos los registros en un nuevo array*/
            Employee[] newStaff = (Employee[]) in.readObject();
            
            /*aumentamos el salario al secretario*/
            newStaff[1].raiseSalary(10);
            
            /*imprimimos el nuevo registro del empleado creado*/
            for(Employee e : newStaff)
            {
                System.out.println(e);
            }
        }
    }
}
