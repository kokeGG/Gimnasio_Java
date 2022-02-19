/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Koke
 */
public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
    
    
        public boolean registarUsuario(Usuario usr)
        {
            con = cn.Conectar();
            //Consulta a la BD para ingresar datos
            String sql = "INSERT INTO Usuario(Usur, Nombre, pass, idEstado, id_tipo) VALUES"
                    + "(?, ?, ?, ?, ?)";
            
            try 
            {
                ps = con.prepareStatement(sql);
            
                ps.setString(1, usr.getUsername());
                ps.setString(2, usr.getNombre());
                ps.setString(3, usr.getPass());
                ps.setInt(4, usr.getId_estado());
                ps.setInt(5, usr.getId_tipo());
                ps.execute();
                return true;
            } 
            catch (SQLException ex) 
            {
                java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }
        
        public int existeUsuario(String usuario)
        {
            con = cn.Conectar();
            //Consulta a la bd para verificar si el usuario existe          
            String sql = "SELECT count (id) FROM Usuario WHERE Usur = ?"; //cuenta cuantos registros hay con el "username"
            
            try 
            {
                ps = con.prepareStatement(sql);
            
                ps.setString(1, usuario);
                ps.execute();
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt(1); //retorna el valor que realiza la cuenta en la consulta
                }
                return 1; // retornarmos 1 para que se crea que hay un usuario, en caso de algún problema
            } 
            catch (SQLException ex) 
            {
                java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return 1;
            }
            
        }
        
        public Usuario listarUsuarioID(String dni){
        Usuario u = new Usuario();
        String sql = "SELECT * FROM Usuario";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setId_estado(rs.getInt(2));
                u.setUsername(rs.getString(3));
                u.setNombre(rs.getString(4));
                u.setPass(rs.getString(6));
                u.setId_tipo(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de los usuarios: " + e);
        }
        
        return u;
    }
        
        
        public boolean login(Usuario usr){
            con = cn.Conectar();
            String sql = "SELECT u.idUsuario, u.Usur, u.pass, u.Nombre, u.id_tipo FROM Usuarios"
                    + "AS u  WHERE Usur = ?";
            
            try {
                ps = con.prepareStatement(sql);
            
                ps.setString(1, usr.getUsername());
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    if (usr.getPass().equals(rs.getString(3))) { //comparamos si la contraseña es igual al de nuestra BD
                        usr.setId(rs.getInt(1));
                        usr.setNombre(rs.getString(4));
                        usr.setId_tipo(rs.getInt(5));
                        return true; //cuando las contraseñas coincidan
                    } else{
                        return false; //cuando las contraseñas no coincidan
                    }
                }
                return false;
            } catch (SQLException ex) 
            {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }   
        
        }
    
}

