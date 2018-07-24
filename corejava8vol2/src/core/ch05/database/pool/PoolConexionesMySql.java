/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.pool;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author PC
 */
public class PoolConexionesMySql {
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        /*Tambien se podria utilizar un archivo de configuraciones y leer la informacion*/
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setUrl("jdbc:mysql://localhost:3306/recursos_humanos?useSLL=false");
        //definir el tamanio o cantidad de conexiones vivas
        ds.setInitialSize(5); //5 conexiones iniciales
        return ds;
    }
    
    public static Connection getConnection() throws SQLException
    {
        return getDataSource().getConnection();
    }
}
