/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.write;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class TextFileTest 
{
    /**
     * Escribimos los datos del empleado con un PrintWriter en formato de Texto
     * @param out el Print Writer
     * @param e 
     */
    public static void writeEmployee(PrintWriter out, Employee e)
    {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }
    
    /** 
     * Escribimos todos los empleados en un array para el Print Writer
     * @param employees es un array de empleados
     * @param out un Print Writer
     * @throws IOException 
     */
    private static void writeData(Employee[] employees, PrintWriter out) throws IOException
    {
        out.println(employees.length);
        for(Employee e : employees)
        {
            writeEmployee(out,e);
        }
    }
    
    /**
     * Leemos datos de empleado desde un buffered reader
     * @param in el scanner
     * @return 
     */
    public static Employee readEmployee(Scanner in)
    {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
    
    /**
     * Leemos de un Array de empleados desde un Scanner
     * @param in
     * @return 
     */
    private static Employee[] readData(Scanner in)
    {
        /* recuperamos el tamano del array */
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for(int i = 0; i < n; i++)
        {
            employees[i] = readEmployee(in);
        }
        return employees;
    }
    
    public static void main(String[] args) throws IOException
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000,1990, 3, 15);
        
        /* guardamos todos los registros en un archivo employee.dat */
        try(PrintWriter out = new PrintWriter("employee.dat", "UTF-8"))
        {
            writeData(staff, out);
        }
        
        /* en un nuevo arreglo, recuperamos todos los registros leyendo el archivo employee.dat*/
        try(Scanner in = new Scanner(
                new FileInputStream("employee.dat"), "UTF-8")) // buscamos en el disco el archivo employee.dat
        {
            Employee[] newStaff = readData(in);
            
            /*imprimimos el nuevo registro recien leido */
            for(Employee e : newStaff)
            {
                System.out.println(e);
            }
        }
    }
}
