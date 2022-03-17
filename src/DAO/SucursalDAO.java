/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author Koke
 */
public class SucursalDAO implements CRUD{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion cn = new Conexion();
    /*
    public boolean registrarSucursal(Sucursal suc){
        ps = null;
        rs = null;
        con = cn.Conectar();
        
        //Consulta a la fckking base de datos para ingresar fcking datos 
        String sql = "INSERT INTO Sucursal(Nombre, Tel, calle, colonia, idUsuario) VALUES"
                + "(?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, suc.getNom());
            ps.setString(2, suc.getTel());
            ps.setString(3, suc.getCalle());
            ps.setString(4, suc.getCol());
            ps.setInt(5, suc.getIdUsuario());
            ps.execute();
            return true;
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }*/
    
    public int existeSucursal(String suc){
        ps = null;
        rs = null;
        con = cn.Conectar();
        
        //verificar si existe en la fkin BD
        String sql = "SELECT COUNT(idSucursal) FROM Sucursal WHERE Nombre = ?";
        
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, suc);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        }catch(SQLException e){
            java.util.logging.Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
    }
    
    public Sucursal listarSucursalID(String id){
        Sucursal s = new Sucursal();
        String sql = "SELECT * FROM Sucursal";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setTel(rs.getString(3));
                s.setCalle(rs.getString(4));
                s.setCol(rs.getString(5));
                s.setCol(rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de las sucursales: " + e);
        }
        return s;
    }
    
    public Sucursal validarSucursal(String dni, String name){
        Sucursal s = new Sucursal();
        String sql = "SELECT * FROM sucursal WHERE idSucursal = ? AND Nombre = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, name);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setTel(rs.getString(3));
                s.setCalle(rs.getString(4));
                s.setCol(rs.getString(5));
                s.setIdUsuario(rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Error al validar sucursal");
        }
        return s;
    }
    
    @Override
    public List listar() {
        List<Sucursal> lista = new ArrayList<>();
        String sql = "SELECT idSucursal, Nombre, Tel, calle, colonia, idUsuario FROM Sucursal;";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Sucursal s = new Sucursal();
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setTel(rs.getString(3));
                s.setCalle(rs.getString(4));
                s.setCol(rs.getString(5));
                s.setIdUsuario(rs.getInt(6));
                
                lista.add(s);
                System.out.println("Sucursales mostradas");
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar sucursales " + e);
        }
        
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO Sucursal(Nombre, Tel, calle, colonia, idUsuario) VALUES(?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Sucursales insertadas");
        } catch (Exception e) {
            System.out.println("Error al insertar sucursales" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Sucursal SET Nombre = ?, Tel = ?, calle = ?, colonia = ?, idUsuario = ? WHERE idSucursal = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
            System.out.println("Sucursales Modificadas");
        } catch (Exception e) {
            System.out.println("Error al modificar sucursales" + e);
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Sucursal WHERE idSucursal = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Sucursal eliminada");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar sucursal" + e);
        }
    }
    
    
}
