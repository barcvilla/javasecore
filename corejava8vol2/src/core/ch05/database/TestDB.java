/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author PC
 */
public class TestDB 
{
    public static void main(String[] args) throws IOException 
    {
        try
        {
            runTest();
        }
        catch(SQLException ex)
        {
            for(Throwable t : ex)
            {
                t.printStackTrace();
            }
        }
    }
    
    /*Ejecutamos una prueba de creacion de tabla, adicion de valor, mostramos el contenido de la tabla, removemos la tabla*/
    public static void runTest() throws SQLException, IOException
    {
        /*Obtenemos un objeto Connection y creamos un Objeto Statement*/
        try(Connection conn = getConnection();
                Statement stat = conn.createStatement())
        {
            /*Usamos ExecuteUpdate para acciones como: INSERT, UPDATE, DELETE y operaciones de definicion de datos
              CREATE TABLE, DROP TABLE*/
            stat.executeUpdate("CREATE TABLE greetings(message character varying(20))");
            stat.executeUpdate("INSERT INTO greetings(message) values('Hello, world!!')");
            
            /*Utilizamos el metodo executeQuery para operaciones SELECT. ExecuteQuery retorna un objeto ResultSet*/
            try(ResultSet result = stat.executeQuery("SELECT * FROM greetings"))
            {
                /*Analizamos el objeto ResultSet*/
                if(result.next())
                {
                    /*inspeccionamos la fila individualmente*/
                    System.out.println(result.getString("message")); /*metodo accesor getString() para obtener dato String*/
                }
            }
            
            //stat.executeUpdate("DROP TABLE greetings");
        }
    }
    
    /*Obtenemos una cadena de conexion desde el archivo de propiedades*/
    public static Connection getConnection() throws SQLException, IOException
    {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties")))
        {
            props.load(in);
        }
        
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers != null)
        {
            System.setProperty("jdbc.drivers", drivers);
        }
        
        /*Nos conectamos a la BD*/
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password =  props.getProperty("jdbc.password");
        
        return DriverManager.getConnection(url, username, password);
    }
}
