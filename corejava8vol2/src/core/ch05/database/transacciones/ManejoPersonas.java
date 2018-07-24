/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.transacciones;

import core.ch05.database.Conexion;
import core.ch05.database.PersonasJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class ManejoPersonas {
    public static void main(String[] args) {
        PersonasJDBC personaJDBC = new PersonasJDBC();
        /*Creamos un objeto Conexion que se va a compartir con todos los queries que ejecutemos*/        
        Connection conn = null;
        try
        {
            conn = Conexion.getConnection();
            /*Revisamos si la conexion esta en modo autocommit. Por default es autocommit = true*/
            if(conn.getAutoCommit())
            {
                conn.setAutoCommit(false);
            }
            /*Creamos el objeto personas de tipo PersonasJDBC y le pasamos la conexion creada*/
            PersonasJDBC personas = new PersonasJDBC(conn);
            /*Empezamos a ejecutar setencias. Recordemos que una Transaccion agrupa varias sentencias SQL. Si algo falla
              no se realizan los cambios en la BD*/
            personas.update(1, "ceva_19@hotmail.com");
            /*Provocamos un error superando los 45 caracteres del campo nombre*/
            personas.insert("Mario", "Perez", 
            "Guzman", "mariop@gmail.com", "563278542");
            // guardamos los cambios
            conn.commit();
        }
        catch(SQLException ex)
        {
            //hacemos rollback en caso de error
            try
            {
                System.out.println("Entremos en un Rollback");
                //imprimimos la excepcion a la consola
                ex.printStackTrace();
                // hacemos rollback
                conn.rollback();
            }
            catch(SQLException ex1)
            {
                ex1.printStackTrace();
            }
        }
    }
}
