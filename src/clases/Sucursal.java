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
    String dni, nom, tel;
    int id;

    //constructor
    public Sucursal() {
    }

    public Sucursal(String dni, String nom, String tel, int id) {
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.id = id;
    }
    
    //metodos de acceso

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
