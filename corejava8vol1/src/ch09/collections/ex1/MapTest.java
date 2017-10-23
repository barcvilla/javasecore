/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex1;

import ch06.interfaces.ex1.Employee06;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author barcvilla
 */
public class MapTest 
{
    public static void main(String[] args) 
    {
        Map<String, Employee06> staff = new HashMap<>();
        
        staff.put("144-25-5464", new Employee06("Amy Lee"));
        staff.put("567-24-2546", new Employee06("Harry Hacker"));
        staff.put("157-62-7935", new Employee06("Gary Cooper"));
        staff.put("456-62-5527", new Employee06("Francesca Cruz"));
        
        // imprimimos las entradas
        System.out.println(staff.toString());
        
        // eliminamos una entrada
        staff.remove("567-24-2546");
        
        // reemplazamos una entrada
        staff.put("456-62-5527", new Employee06("Francesca Miller"));
        
        // buscamos un valor
        System.out.println(staff.get("157-62-7935").toString());
        
        // iteramos sobre la coleccion
        staff.forEach((k,v) ->
            System.out.println("Key = " + k + ", value = " + v.toString() ));
    }
}
