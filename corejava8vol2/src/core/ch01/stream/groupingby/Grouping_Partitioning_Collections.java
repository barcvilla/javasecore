/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.groupingby;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Grouping by: Nos permite formar grupo con las mismas caracteristicas.
 * @author barcvilla
 */
public class Grouping_Partitioning_Collections 
{
    /**
     * Agrupamos locales por pais.
     * Locale::getCountry es la funcion clasificador de la agrupacion. Ahora podemos buscar todas las
     * configuraciones regionales para un codigo de pais dado.
     */
    public static void getAllLanguages()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryLocales = locales.collect(
        Collectors.groupingBy(Locale::getCountry));
        System.out.println("Country Locales: " + countryLocales);
    }
    
    public static void getRegionalConfigByCountry(String country)
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryLocales = locales.collect(
        Collectors.groupingBy(Locale::getCountry));
        List<Locale> swissLocales = countryLocales.get(country);
        System.out.println(country +  " Locale: " + swissLocales);
    }
    
    /**
     * Cuando la funcion Clasificador es una funcion predicado(esto es, una funcion qu retorna un valor boolean)
     * El stream es particionado en dos listas: Aquellas donde la funcion retorna true y el complemento.
     * En este caso, es mas eficiente usar partitioningBy en lugar de groupingBy
     */
    public static void getRegionalConfigUsingPartitioningBy()
    {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
        Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println("English locale: " + englishLocales);
    }
    
    public static void main(String[] args)
    {
        getAllLanguages();
        getRegionalConfigByCountry("CH");
        getRegionalConfigUsingPartitioningBy();
    }
}
