/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.downstream;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class DownStreamCollectors 
{
    /**
     * El metodo Collectors.groupingBy() produce un Map cuyos valores son Listas. Por ejemplo
     * si deseamos un Set en lugar de una List podemos utilizar Collectors.toSet().
     */
    public static void getAllCountries()
    {   
        Stream<Locale> locales  = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
        Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        System.out.println("Coutry Locales: " + countryToLocaleSet);
    }
    
    /**
     * Reduccion de los elementos agrupados a numeros.
     * Collectors.counting() produce un recuento de los elementos recolectados.
     */
    public static void countingCountriesElements()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(
        Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        System.out.println("Counting Country Locales: " + countryToLocaleCounts);
    }
    
    public static void getAllLanguageInCountry()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,Set<String>> countryToLanguage = locales.collect(
        Collectors.groupingBy(Locale::getDisplayCountry,
                Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
        System.out.println("Get all Languages in a Country: " + countryToLanguage);
    }
    
    public static void main(String[] args)
    {
        getAllCountries();
        countingCountriesElements();
        getAllLanguageInCountry();
    }
}
