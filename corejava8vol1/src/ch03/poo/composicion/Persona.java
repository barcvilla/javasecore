/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.poo.composicion;

/**
 *
 * @author PC
 */
public class Persona {
    /*Atributo de Clase*/
    public static String nombre;
    /*Atributos de instancia*/
    public float estatura;
    
    public static int cantidad; //este miembro de clase no se instanciara cada vez q se crea un el objeto Persona
    
    public Persona()
    {
        cantidad++;
    }
    
    public static int getCantidad()
    {
        return cantidad;
    }
    
    /*Metodo de instancia*/
    public void saludar()
    {
        System.out.println("Hola amigos");
    }
    
    /*Metodo de clase*/
    public static void adios()
    {
        System.out.println("Adios mis amigos");
    }
}
