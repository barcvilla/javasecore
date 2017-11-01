/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex2;

import ch06.interfaces.ex1.Employee06;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author barcvilla
 */
public class LightweightCollectionWrappers 
{
    public static void main(String[] args) 
    {
        /**
         * El metodo static asList() de una clase Arrays retorna un List envuelto de un Java Array Plain
         * Este metodo nos permite pasar el array a un metodo que espera una lista o coleccion como argumento
         */
        List<Employee06> names = Arrays.asList(new Employee06("Juan", 10000), new Employee06("Pedro", 40000));
        
        /**
         * El siguiente ejemplo crea una lista con 100 strings, todos diciendo "DEFAULT"
         */
        List<String> settings = Collections.nCopies(100, "DEFAULT");
        
        /**
         * El siguiente metodo produce un set, list, map y asi vacio para cada interface de framework collection
         */
        Set<String> setVacio = Collections.emptySet();
        
        /**
         * Podemos formar una vista subrango de una coleccion. Por ejemplo, tenemos una lista staff y queremos
         * extraer los elementos del 5 al 9. Usamos el metodo sublist para obtener una vista de subrango
         * staff.subList(4, 9) excluye el primer parametro e incluye el segundo.
         */
        List<Employee06> staff = new ArrayList<Employee06>();
        
        staff.add(new Employee06("Manuel", 10000));
        staff.add(new Employee06("Fernando", 20000));
        staff.add(new Employee06("Pedro", 30000));
        staff.add(new Employee06("Juan", 40000));
        staff.add(new Employee06("Alvaro", 50000));
        staff.add(new Employee06("Mateo", 60000));
        staff.add(new Employee06("Sergio", 70000));
        staff.add(new Employee06("John", 80000));
        staff.add(new Employee06("Mariana", 90000));
        staff.add(new Employee06("Guillermo", 100000));
        
        List<Employee06> subStaff = staff.subList(3, 6);
        
        for(Employee06 emp : subStaff)
        {
            System.out.println(emp.getName() + ", " + emp.getSalary());
        }
    }
}
