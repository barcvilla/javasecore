/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.collecting_to_map;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
        // Producimos un Map de clave/valor
        Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);
    }
    
    public static void functionIdentity()
    {
        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: "  + idToPerson);
    }
    
    public static void creatingTreeMap()
    {
        Map<Integer, Person>idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(),
                (existingValue, newValue) -> 
                {
                    throw new IllegalStateException();
                }, TreeMap::new));
        System.out.println("creating tree map idToPerson: " + idToPerson.getClass().getName() + idToPerson);
    }
    
    public static void getAllLanguage()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languagesName = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
        System.out.println("Languages Names: " + languagesName);
    }
    
    public static void getAllLanguageByCountry()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
        Collectors.toMap(
                Locale::getDisplayCountry,
                // generamos un singleton set para cada set value (lenguajes)
                l -> Collections.singleton(l.getDisplayLanguage()),
                (a,b) -> 
                {
                    //union of a and b. Aplicamos un Merge del valor existente y del nuevo valor
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }));
        System.out.println("Country Language Sets: " + countryLanguageSets);
    }
    
    public static void main(String[] args) 
    {
        getPeople();
        functionIdentity();
        creatingTreeMap();
        getAllLanguage();
        getAllLanguageByCountry();
    }
}
