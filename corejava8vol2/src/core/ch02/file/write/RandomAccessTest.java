/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.write;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class RandomAccessTest 
{
    /**
     * Escribimos datos del Empleado hacia un DataOutput
     * @param out
     * @param e
     * @throws IOException 
     */
    public static void writeData(DataOutput out, Employee e) throws IOException
    {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }
    
    /**
     * Lee los datos del empleado de un DataInput
     * @param in
     * @return
     * @throws IOException 
     */
    public static Employee readData(DataInput in) throws IOException
    {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        
        return new Employee(name, salary, y, m-1, d);
    }
    
    public static void main(String[] args) throws IOException
    {
        Employee[] staff = new Employee[3];
        
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee1.dat")))
        {
            /*Escribimos los datos en employee1.dat*/
            for(Employee e : staff)
            {
                writeData(out, e);
            }
        }
        
        try(RandomAccessFile in = new RandomAccessFile("employee1.dat", "r"))
        {
            /*Recuperamos todos los registros en un array*/
            /*calculamos el tamano del array*/
            int n = (int)(in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            
            /*Leemos los datos del empleado en orden reverso*/
            for(int i = n - 1; i >= 0; i--)
            {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            
            /*Impresion del nuevo registro leido del empleado*/
            for(Employee e : newStaff)
            {
                System.out.println(e);
            }
        }
    }
}
