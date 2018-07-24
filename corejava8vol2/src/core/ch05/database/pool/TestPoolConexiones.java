/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.pool;
import core.ch05.database.pool.PoolConexionesMySql;
import java.sql.*;
/**
 *
 * @author PC
 */
public class TestPoolConexiones {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            //probamos el pool de conexion mysql
            conn = PoolConexionesMySql.getConnection();
            System.out.println("Utilizando el Pool de Conexiones a MySQL");
            stmt = conn.prepareStatement("SELECT * from persona");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                System.out.println("Id: " + rs.getInt(1) + " Nombre: " + rs.getString(2) + " A.Paterno: " + rs.getString(3) + 
                        " A.Materno: " + rs.getString(4) + " Email: " + rs.getString(5) + " Telefono: " + rs.getString(6));
            }
            conn.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
