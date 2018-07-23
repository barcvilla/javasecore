/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database;
import java.sql.*;
/**
 *
 * @author PC
 */
public class Conexion {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/recursos_humanos?useSSL=false";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "admin";
    private static Driver driver = null;
    
    // synchronized permite que un solo hilo puede ejecutar este metodo a la vez
    public static synchronized Connection getConnection() throws SQLException
    {
        if(driver == null)
        {
            try
            {
                //carga en memoria el driver de mysql
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                //creamos una instancia de la clase Driver
                driver = (Driver) jdbcDriverClass.newInstance();
                //registramos nuestra variable driver
                DriverManager.registerDriver(driver);
                
            }
            catch(Exception ex){
                System.out.println("Fallo en cargar el driver JDBC");
                ex.printStackTrace();
            }
        }
        //si no ocurrio ningun error retornamos la conexion instanciada
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try
        {
            if(rs != null)
            {
                rs.close();
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement pst)
    {
        try
        {
            if(pst != null)
            {
                pst.close();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    //cerramos la conexion
    public static void close(Connection cn)
    {
        try
        {
            if(cn != null)
            {
                cn.close();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
