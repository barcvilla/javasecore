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
public class Ejecutar {
    public static void main(String[] args) {
        /*Accedemos al atributo static de clase Persona. Aqui no se necesita instancia de la clase Persona*/
        Persona.nombre = "Juan";
        System.out.println(Persona.nombre);
        
        /*Accedemos al metodo de clase static adios() de la clase Persona*/
        Persona.adios();
        
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Persona p3 = new Persona();
        Persona p4 = new Persona();
        Persona p5 = new Persona();
        
        System.out.println("Se ha creado " + Persona.getCantidad() + " personas");
    }
}
