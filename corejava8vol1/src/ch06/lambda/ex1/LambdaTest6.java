/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import ch04.classes.employee.ex2.Employee02;
import java.util.function.Supplier;

/**
 *
 * @author barcvilla
 */
public class LambdaTest6 {
    public static void main(String[] args) {
        // se crea un supplier de tipo empleado, el cual obtiene un empleado
        Supplier<Employee02> emp = () -> new Employee02("Juan Alvarez", 40000, 2017, 10, 22);
    }
    
    
}
