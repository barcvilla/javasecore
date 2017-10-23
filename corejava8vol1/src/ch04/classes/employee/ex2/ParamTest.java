/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.classes.employee.ex2;
/**
 *
 * @author Carlos Villanueva
 */
public class ParamTest {
    public static void main(String[] args)
    {
        //=====================================================
        //Test 1: Metodos no pueden modificar parametros
        //=====================================================
        System.out.println("Testing tripeValue");
        double percent = 10;
        System.out.println("Antes: percent= " + percent);
        tripleValue(percent);
        
        //============================================================
        //Test 2: Metodo pueden cambiar el estado de los obj parameter
        //============================================================
        System.out.println("Testing tripleSalary");
        Employee02 harry = new Employee02("Harry", 50000, 1980, 11, 20);
        System.out.println("Antes: Salario= " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("Despues: salario= " + harry.getSalary());
        
        //==============================================================
        // Test 3: Metodos no pueden adjuntar nuevos obj a los obj param
        //==============================================================
        System.out.println("Tesitng Swap");
        Employee02 a = new Employee02("Manuel", 70000, 1981, 10, 22);
        Employee02 b = new Employee02("Pedro", 60000, 1982, 7, 20);
        System.out.println("Antes: a = " + a.getName());
        System.out.println("Antes: b = " + b.getName());
        swap(a, b);
        System.out.println("Despues: a = " + a.getName());
        System.out.println("Despues: b = " + b.getName());
        
        
    }
    
    public static void tripleValue(double x) // no funciona
    {
        x = 3 * x;
        System.out.println("Fin del metodo: x = " + x);
    }
    
    public static void tripleSalary(Employee02 x)
    {
        x.raiseSalary(200);
        System.out.println("End of method: Salary = " + x.getSalary());
    }
    
    public static void swap(Employee02 x, Employee02 y)
    {
        Employee02 tmp = x;
        x = y;
        y = tmp;
        System.out.println("Fin del metodo: x= " + x.getName());
        System.out.println("Fin del metodo: y= " + y.getName());
    }
}
