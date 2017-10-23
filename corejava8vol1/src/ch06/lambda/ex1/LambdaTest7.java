/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.lambda.ex1;

import ch04.classes.employee.ex2.Employee02;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author barcvilla
 */
public class LambdaTest7 {
    public static void main(String[] args) {
        List<Employee02> names = new ArrayList<Employee02>();
        names.add(new Employee02("Juan",20000, 2014, 5, 10));
        names.add(new Employee02("Pedro", 40000, 2014, 5, 11));
        names.add(new Employee02("Mario", 15000, 2014, 6, 9));
        names.add(new Employee02("Carlos", 55000, 2015, 1, 2));
        names.add(new Employee02("Walter", 60000, 2015, 3, 20));
        names.add(new Employee02("Alfonso", 40000, 1982, 7, 20));
        
        // Recorremos la el ArrayList
        names.forEach(e -> System.out.println(e.toString()));
        
        // Predicate<Tipo>
        // predicado : obtiene el numero de empleados con salario mayor a 25000
        System.out.println("Ejemplo de predicado: ");
        System.out.println("Usuarios con sueldo mayor a 20000: " + 
                names.stream()
                .filter(x -> x.getSalary() > 20000)
                .collect(Collectors.toCollection(() -> new ArrayList<Employee02>())));
        
        // Function<T,R>
        // Function: obtiene la direccion que corresponde al empleado
        
        // Consumer<Tipo>
        // ejemplo consumidor: Actualiza nombre del empleado de la posicion 0 de la lista
        System.out.println("\nEjemplo de consumidor:");
        Consumer<Employee02> updateName = u -> u.setName("Juan Fernandez");
        updateName.accept(names.get(0));
        // imprime la lista con el Empleado acutalizado
        names.forEach(e -> System.out.println(e.toString()));
        
        // Supplier<Tipo>
        // proveedor: Crea un nuevo Employee y lo imprime
        System.out.println("\nEjemplo de Supplier");
        Supplier<Employee02> emp = () -> new Employee02("Alfonso Gonzalez", 44000, 2010, 9, 20);
        System.out.println(emp.get().toString());
        
    }
}
