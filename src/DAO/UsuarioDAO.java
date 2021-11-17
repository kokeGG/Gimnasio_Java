/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Usuario;

/**
 *
 * @author Ing_O
 */
public class UsuarioDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;    
    Conexion cn = new Conexion();
    
    public Usuario validatarUsuario(String usuario, String pwd){
        Usuario us = new Usuario();
        String sql = "SELECT * FROM usuario WHERE  usuario  = ? and pass = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            
            while (rs.next()) {       
            	
                us.setId(rs.getInt(1));
                us.setIdEstado(rs.getInt(2));
                us.setUsuario(rs.getString(3));
                us.setNombre(rs.getString(4));
                us.setFechaCreacion(rs.getDate(5));
            }
        } catch (Exception e) {
            System.out.println("Error to validate user");
        }
        return us;
    }
       
}
