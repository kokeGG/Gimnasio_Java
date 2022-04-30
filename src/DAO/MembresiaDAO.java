
package DAO;

import clases.Membresia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MembresiaDAO implements CRUD{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public int existeMembresia(String membresia)
        {
            ps = null;
            rs = null;
            con = cn.Conectar();
            //Consulta a la bd para verificar si el usuario existe          
            String sql = "SELECT COUNT(idMembresia) FROM Membresia WHERE Nombre = ?"; //cuenta cuantos registros hay con el "username"
            
            try 
            {
                ps = con.prepareStatement(sql);
                ps.setString(1, membresia);
                //ps.execute();
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
    
    @Override
    public List listar() {
         List<Membresia> lista = new ArrayList<>();
         String sql = "SELECT * FROM Membresia";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {         
                Membresia memb = new Membresia();
                memb.setId(rs.getInt(1));
                memb.setNombre(rs.getString(2));
                memb.setIdEstado(rs.getInt(3));
                memb.setFechaCreacion(rs.getString(4));
                memb.setPrecio(rs.getFloat(5));
                memb.setMeses(rs.getInt(6));
               
                lista.add(memb);
             
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar membresias" + e);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO Membresia (Nombre, idEstado, fechaCreacion, Precio, meses) VALUES"
                    + "(?, ?, ?, ?, ?)";
            
            try 
            {
                con = cn.Conectar();
                ps = con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]);
                ps.setObject(5, o[4]);
                r = ps.executeUpdate();
                System.out.println("Membresia agregada");
            } 
            catch (Exception e) 
            {
                
                System.out.println("Error al agregar membresias" + e);
                
            }
            return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Membresia SET Nombre = ?, idEstado = ?, fechaCreacion = ?, Precio = ?, meses = ? WHERE idMembresia = ?";
        
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
            System.out.println("Membresia modificada");
        } catch (Exception e) {
            System.out.println("Error al modificar membresia" + e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Membresia WHERE idMembresia = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("Membresia eliminada");
        } catch (Exception e) {
            System.out.println("Error al eliminar membresia " + e);
        }
    }
    
}
