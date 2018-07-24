/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database;
import java.sql.*;
import java.util.*;
/**
 * Usamos la misma conexion para todas las operaciones CRUD. Ya que cuando trabajamos con Transacciones debemos utilizar la misma
 * conexion para asi poder realizar un commit o rollback de toda la transaccion, es decir, utilizando la misma conexion de principio
 * a fin.
 * @author PC
 */
public class PersonasJDBC {
    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido_paterno, apellido_materno, email, telefono) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET email = ? WHERE id_persona = ?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT = "SELECT * FROM persona ORDER BY id_persona";
    
    private java.sql.Connection userConn;
    
    public PersonasJDBC(){}
    
    public PersonasJDBC(Connection conn)
    {
        this.userConn =  conn;
    }
    
    public int insert(String nombre, String ape_paterno, String ape_materno, String email, String telefono)throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            /*Variable userconn ya fue inicializada?. si lo fue vamos a reutilizar la conexion de lo contrario solicitamos conexion*/
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, nombre); // param 1 => ?
            stmt.setString(index++, ape_paterno); // param 2 => ?
            stmt.setString(index++, ape_materno);
            stmt.setString(index++, email);
            stmt.setString(index++, telefono);
            System.out.println("Ejecutando query: " +  SQL_INSERT);
            rows = stmt.executeUpdate(); // nro registros afectados
            System.out.println("Registros afectados: " + rows);
        }
        finally //omitimos el bloque catch para poder lanzar la excepcion al caller de la funcion.
        {
            Conexion.close(stmt);
            if(this.userConn == null) //de lo contrario mantenemos activa la conexion durante el tiempo de vida de la clase PersonaJDBC
            {
                Conexion.close(conn);
            }
        }
        return rows;
    }
    
    public int update(int id_personas, String email) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, email);
            stmt.setInt(index++, id_personas);
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
    
    public int delete(int id_persona) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
           conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE); 
            stmt =  conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_persona);
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
    
    public List<Persona> select() throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
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
                persona = new Persona(id_persona, nombre, ape_paterno, ape_materno, email, telefono);
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
