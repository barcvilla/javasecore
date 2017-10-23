/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.abstracts.ex1;

import java.util.Objects;

/**
 *
 * @author jcva175
 */
public abstract class Person {
    
    // clases abstractas puede incluir campos
    private String name;
    
    // clases abstractas puede tener constructor
    public Person(String name)
    {
        this.name = name;
    }
    // abstract method
    public abstract String getDescription();
    
    public boolean equals(Object otherObject)
    {
        // preguntamos si los objetos son identicos
        if(this == otherObject)
        { 
            return true;
        }
        
        // retorna false si el parametro explicito es null
        if(otherObject == null)
        {
            return false;
        }
        
        // si las clases no coinciden no puede ser iguales
        if(getClass() != otherObject.getClass())
        {
            return false;
        }
        
        Person other = (Person) otherObject;
        
        return Objects.equals(name, other.name);
    }
    
    public String getName()
    {
        return name;
    }
    
    public int hashCode()
    {
        return Objects.hash(name);
    }
    
    public String toString()
    {
        return getClass().getName() + ": name = " + name ;
    }
}
