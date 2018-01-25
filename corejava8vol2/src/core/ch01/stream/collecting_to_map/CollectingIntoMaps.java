/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.collecting_to_map;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class CollectingIntoMaps 
{
    public static Stream<Person> people()
    {
        return Stream.of(new Person("Peter", 20000), new Person("Paul", 25000), new Person("Mary", 26000));
    }
    
    public static void getPeople()
    {
        Map<Integer, String> idToName = people().collect(
        Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);
    }
    
    public static void functionIdentity()
    {
        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: "  + idToPerson);
    }
    
    
    public static void main(String[] args) 
    {
        getPeople();
        functionIdentity();
    }
}
