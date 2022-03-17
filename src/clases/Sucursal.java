/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Koke
 */
public class Sucursal {
    String nom, tel, calle, col;
    int id, idUsuario, idMiembros;

    //constructor
    public Sucursal() {
    }

    public Sucursal(String nom, String tel, String calle, String col, int id, int idUsuario, int idMiembros) {
        this.nom = nom;
        this.tel = tel;
        this.calle = calle;
        this.col = col;
        this.id = id;
        this.idUsuario = idUsuario;
        this.idMiembros = idMiembros;
    }
    
    //metodos de acceso
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMiembros() {
        return idMiembros;
    }

    public void setIdMiembros(int idMiembros) {
        this.idMiembros = idMiembros;
    }
}
