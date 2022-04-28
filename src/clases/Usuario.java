/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Koke
 */
public class Usuario {
    int id, id_estado, id_tipo, id_sucursal;
    String username, nombre, apellidoP, pass, nombrerol, fechaCreacion;
    
    public Usuario() {
    }

    public Usuario(int id, int id_estado, int id_tipo, int id_sucursal, String username, String nombre, String apellidoP, String pass, String nombrerol, String fechaCreacion) {
        this.id = id;
        this.id_estado = id_estado;
        this.id_tipo = id_tipo;
        this.id_sucursal = id_sucursal;
        this.username = username;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.pass = pass;
        this.nombrerol = nombrerol;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    
}

