/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.test;

import core.ch05.database.dto.PersonaDTO;
import core.ch05.database.jdbc.PersonaDAO;
import core.ch05.database.jdbc.PersonaDaoJDBC;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class TestPersona {
    
    //Usamos el tipo interface como referencia a una clase concreta.
     static PersonaDAO personaDao = new PersonaDaoJDBC();
    
    public static void insertPersona()
    {
        
        /*Creamos un nuevo registro. Hacemos uso de la clase PersonaDTO*/
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Jonathan");
        persona.setApe_paterno("Lara");
        persona.setApe_materno("Fajardo");
        persona.setEmail("jlara@gmail.com");
        persona.setTelefono("914523698");
        
        try
        {
            personaDao.insert(persona);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void updatePersona(int id, String email)
    {
        PersonaDTO temp = new PersonaDTO(id);
        temp.setEmail(email);
        try
        {
            personaDao.update(temp);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void deletePersona(int id)
    {
        try
        {
            personaDao.delete(new PersonaDTO(id));
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void getPersonas()
    {
        try
        {
            List<PersonaDTO> personas = personaDao.select();
            for(PersonaDTO p : personas)
            {
                System.out.println(p);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        //insertPersona();
        //deletePersona(4);
        //updatePersona(8, "j.lara@aol.com");
        getPersonas();
    }
}
