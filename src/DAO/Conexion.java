/*
 * GYM SCORPION
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Koke
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost/gymescorpion";
    String user = "root";
    String pass = "OMARomar2021*";
    
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Success");
        }catch (ClassNotFoundException e){
            System.out.println("error check mysql driver for java " + e);
        } catch (SQLException r){
            System.out.println("DB error " + r);
        }
        return con;
    }
}
