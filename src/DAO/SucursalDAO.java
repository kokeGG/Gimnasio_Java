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
import java.util.ArrayList;
import java.util.List;
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
    
    public Sucursal listarSucursalID(String dni){
        Sucursal s = new Sucursal();
        String sql = "SELECT * FROM sucursal";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            while (rs.next()) {
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setTel(rs.getString(3));
                s.setCalle(rs.getString(4));
                s.setCol(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al listar ID de las sucursales: " + e);
        }
        return s;
    }
    
    public Sucursal validarSucursal(String dni, String user){
        Sucursal s = new Sucursal();
        String sql = "SELECT * FROM sucursal WHERE dni = ? AND user = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setTel(rs.getString(3));
                s.setCalle(rs.getString(4));
                s.setCol(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al validar sucursal");
        }
        return s;
    }
    
    @Override
    public List listar() {
        List<Sucursal> lista = new ArrayList<>();
        String sql = "SELECT * FROM sucursal";
        
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
        String sql = "INSERT INTO sucursal (dni, user, tel) values (?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
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
        String sql = "UPDATE sucursal SET dni = ?, user = ?, tel = ? WHERE id = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
            System.out.println("Sucursales Modificadas");
        } catch (Exception e) {
            System.out.println("Error al modificar sucursales" + e);
        }
        
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM sucursal WHERE id = ?";
        
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
