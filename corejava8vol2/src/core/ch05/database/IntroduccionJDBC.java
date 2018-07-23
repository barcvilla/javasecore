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
public class IntroduccionJDBC {
    public static void main(String[] args) {
        // cadena de conexion a Mysql Server. el parametro useSSL es opcional pero puede arrojar un warning, asi que hay q incluirlo
        String url = "jdbc:mysql://localhost:3306/recursos_humanos?useSSL=false";
        // cargamos el driver mysql
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //creamos objeto conexion. Driver manager retorna un objeto tipo conecction por lo que hacemos un cast
            Connection connection = (Connection)DriverManager.getConnection(url, "root", "admin");
            Statement instruccion =  connection.createStatement();
            // creamos query
            String query = "Select * from persona";
            ResultSet rs = instruccion.executeQuery(query);
            while(rs.next())
            {
                System.out.print("Id: " + rs.getInt(1));
                System.out.print(" Nombre: " + rs.getString(2));
                System.out.print(" Apellidos: " + rs.getString(3) + " " + rs.getString(4));
                System.out.print(" Email: " + rs.getString(5));
                System.out.print(" Telefono: " + rs.getString(6));
                System.out.println();
            }
            //cerramos los recursos
            rs.close();
            instruccion.close();
            connection.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
