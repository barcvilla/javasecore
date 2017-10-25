/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.collections.ex1;

import ch06.interfaces.ex1.Employee06;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author barcvilla
 */
public class MapViews 
{
    public static void main(String[] args) 
    {
        Map<String, Employee06> staff = new HashMap<>();    
        staff.put("144-25-5464", new Employee06("Amy Lee"));
        staff.put("567-24-2546", new Employee06("Harry Hacker"));
        staff.put("157-62-7935", new Employee06("Gary Cooper"));
        staff.put("456-62-5527", new Employee06("Francesca Cruz"));
        
        /**
         * Retorna un set view de todas las key del map. Podemos remover elementos de este set y los valores
         * key asociados son removidos del map, pero no podemos adicionar elementos al map
         */
        Set<String> staffKeys = staff.keySet();
        for(String key : staffKeys)
        {
            System.out.println("Staff Key = " + key);
        }
        
        /**
         * Retornamos un set view de objetos Map.Entry, par key/view en el map. Podemos remover elementos
         * de este set y ellos son removidos del map, pero no podemos adicionar ningun elemento
         */
        for(Map.Entry<String, Employee06> myStaff : staff.entrySet())
        {
            System.out.println("Key = " + myStaff.getKey() + ", value = " + myStaff.getValue());
        }
        
        /**
         * Collection<V> values()
         * retorna un collection view de todos los valores del map. Podemos remover elementos desde este
         * set y el valore removido y su key son removidos del map,pero no podemos adicionar ningun elemento
         */
        System.out.println(staff.values());
    }
}
