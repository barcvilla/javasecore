/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.transacciones;

import core.ch05.database.*;
import java.util.List;

/**
 *
 * @author PC
 */
public class ManejoPersonas {
    public static void main(String[] args) {
        PersonasJDBC personaJDBC = new PersonasJDBC();
        // prueba metodo insert
        //personaJDBC.insert("Fernando", "Alvarez", "Jimenez", "f.alvarez@gmail.com", "155968235");
        //personaJDBC.update(1, "barcvilla@gmail.com");
        //personaJDBC.delete(5);
        List<Persona> personas = personaJDBC.select();
        for(Persona persona : personas)
        {
            System.out.println(persona);
        }
    }
}
