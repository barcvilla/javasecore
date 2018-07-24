/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.jdbc;

import core.ch05.database.dto.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interface PersonaDAO
 * @author PC
 */
public class PersonaDaoJDBC implements PersonaDAO{
    
    private java.sql.Connection userConn;
    
    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido_paterno, apellido_materno, email, telefono) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET email = ? WHERE id_persona = ?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT = "SELECT * FROM persona ORDER BY id_persona";
    
    public PersonaDaoJDBC(){}
    
    public PersonaDaoJDBC(Connection conn)
    {
        this.userConn =  conn;
    }

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            /*Variable userconn ya fue inicializada?. si lo fue vamos a reutilizar la conexion de lo contrario solicitamos conexion*/
            conn = (this.userConn != null) ? this.userConn : core.ch05.database.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, persona.getNombre()); // param 1 => ?
            stmt.setString(index++, persona.getApe_paterno()); // param 2 => ?
            stmt.setString(index++, persona.getApe_materno());
            stmt.setString(index++, persona.getEmail()); 
            stmt.setString(index++, persona.getTelefono());
            System.out.println("Ejecutando query: " +  SQL_INSERT);
            rows = stmt.executeUpdate(); // nro registros afectados
            System.out.println("Registros afectados: " + rows);
        }
        finally //omitimos el bloque catch para poder lanzar la excepcion al caller de la funcion.
        {
            Conexion.close(stmt); //cerramos el objeto de tipo PreparedStatement
            if(this.userConn == null) //de lo contrario mantenemos activa la conexion durante el tiempo de vida de la clase PersonaJDBC
            {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, persona.getEmail());
            stmt.setInt(index++, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }
        finally
        {
            Conexion.close(stmt);
            if(this.userConn == null){Conexion.close(conn);}
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
           conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE); 
            stmt =  conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows); 
        }
        finally
        {
            Conexion.close(stmt);
            if(this.userConn == null){Conexion.close(conn);}
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String ape_paterno = rs.getString(3);
                String ape_materno = rs.getString(4);
                String email = rs.getString(5);
                String telefono = rs.getString(6);
                
                persona = new PersonaDTO(id_persona);
                persona.setNombre(nombre);
                persona.setApe_paterno(ape_paterno);
                persona.setApe_materno(ape_materno);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                personas.add(persona);
            }
        }
        finally
        {   
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){Conexion.close(conn);}
        }
        return personas;
    }
    
}
