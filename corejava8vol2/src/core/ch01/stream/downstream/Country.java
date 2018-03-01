/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch01.stream.downstream;

/**
 *
 * @author barcvilla
 */
public class Country 
{
    private String name;
    private String city;
    private int population;
    
    
    public Country(String name, String city)
    {
        this.name = name;
        this.city = city;
    }
    
    public Country(String name, String city, int population)
    {
        this.name = name;
        this.city = city;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
