/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.downstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author barcvilla
 */
public class DownStreamCollectors1 
{
    public static Stream<Locale> locales = null;
    
    public static Stream<Country> readCountries(String fileName) throws IOException
    {
        return Files.lines(Paths.get(fileName)).map(l -> l.split(",")).map(a -> new Country(a[0], a[1], 
                Integer.parseInt(a[2])));
    }
    
    public static void printCountryLocaleSet()
    {
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(Collectors.groupingBy(
                Locale::getCountry,Collectors.toSet()));
        System.out.println("countryToLocaleSet: " + countryToLocaleSet);
    }
    
    public static void countCountryToLocale()
    {
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(Collectors.groupingBy(
                Locale::getCountry,Collectors.counting()));
        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);
    }
    
    public static void countCitiesinCountry()
    {
        try
        {
            Stream<Country> countries = readCountries("./rs/countries.txt");
            Map<String,Long> countryToCityNames = countries.collect(Collectors.groupingBy(
                    Country::getName, Collectors.counting()));
            System.out.println("countryToCity: " + countryToCityNames);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void compareLongestCityName()
    {
        try
        {
            Stream<Country> countries = readCountries("./rs/countries.txt");
            Map<String, Optional<String>> stateToLongestCityNames = countries.collect(Collectors.groupingBy(
                    Country::getName, Collectors.mapping(Country::getCity, Collectors.maxBy(
                    Comparator.comparing(String::length)))));
            System.out.println("countryToLongestCityName: " + stateToLongestCityNames);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void printCountryToLanguage()
    {
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(Collectors.groupingBy(
                Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
        System.out.println("countryToLanguages: " + countryToLanguages);
    }
    
    public static void printCountryPopulationSummary()
    {
        try
        {
            Stream<Country> countries = readCountries("./rs/countries.txt");
            Map<String, IntSummaryStatistics> countryToCityPopulationSummary = countries.collect(
            Collectors.groupingBy(Country::getName, Collectors.summarizingInt(Country::getPopulation)));
            System.out.println(countryToCityPopulationSummary.get("Afghanistan"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void joiningCountryCity()
    {
        try
        {
            Stream<Country> countries = readCountries("./rs/countries.txt");
            Map<String, String> stateToCity = countries.collect(Collectors.groupingBy(
                    Country::getName, Collectors.mapping(Country::getCity, Collectors.joining(","))));
            System.out.println("CountryToCityNames: " + stateToCity);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        printCountryLocaleSet();
        countCountryToLocale();
        countCitiesinCountry();
        compareLongestCityName();
        printCountryToLanguage();
        printCountryPopulationSummary();
        joiningCountryCity();
    }
}
