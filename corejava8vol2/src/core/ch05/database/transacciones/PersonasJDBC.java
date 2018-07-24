/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.transacciones;

import java.sql.*;
import java.util.*;
/**
 *
 * @author PC
 */
public class PersonasJDBC {
    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido_paterno, apellido_materno, email, telefono) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET email = ? WHERE id_persona = ?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT = "SELECT * FROM persona ORDER BY id_persona";
    
    public int insert(String nombre, String ape_paterno, String ape_materno, String email, String telefono)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, nombre); // param 1 => ?
            stmt.setString(2, ape_paterno); // param 2 => ?
            stmt.setString(3, ape_materno);
            stmt.setString(4, email);
            stmt.setString(5, telefono);
            System.out.println("Ejecutando query: " +  SQL_INSERT);
            stmt.execute(); // nro registros afectados
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
                    
    }
    
    public int update(int id_personas, String email)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, email);
            stmt.setInt(index, id_personas);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }
        catch(SQLException ex){ex.printStackTrace();}
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int delete(int id_persona)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
           conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE); 
            stmt =  conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows); 
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public List<Persona> select()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try
        {
            conn = Conexion.getConnection();
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
                persona = new Persona(id_persona, nombre, ape_paterno, ape_materno, email, telefono);
                personas.add(persona);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {   
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }
    
}
