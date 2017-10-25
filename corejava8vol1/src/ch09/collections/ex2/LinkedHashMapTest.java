/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex2;

import ch06.interfaces.ex1.Employee06;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashSet y LinkedHashMap recuerdan en que orden insertamos los items. 
 * @author barcvilla
 */
public class LinkedHashMapTest 
{
    public static void main(String[] args) {
        Map<String, Employee06> staff = new LinkedHashMap<>();
        staff.put("144-25-5464", new Employee06("Amy Lee"));
        staff.put("567-24-2546", new Employee06("Harry Hacker"));
        staff.put("157-62-7935", new Employee06("Gary Cooper"));
        staff.put("456-62-5527", new Employee06("Francesca Cruz"));
        
        // staff.keySet().iterator() enumera las llaves
        Iterator<String> keys = staff.keySet().iterator();
        while(keys.hasNext())
        {
            System.out.println(keys.next());
        }
        
        // staff.values().iterator enumera todos los valores
        Iterator<Employee06> values = staff.values().iterator();
        while(values.hasNext())
        {
            System.out.println(values.next().getName());
        }
    }
}
