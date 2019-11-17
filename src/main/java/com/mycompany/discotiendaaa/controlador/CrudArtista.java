/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.ArtistaDB;
import com.mycompany.discotiendaaa.pojo.Artista;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author angie
 */
@Named(value = "artista")
@SessionScoped
public class CrudArtista implements Serializable{
    
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public void crearArtista(){
        Artista artista=llenarArtista();
        ArtistaDB db= new ArtistaDB();
        db.agregarCancion(artista);
    }
    
    public Artista llenarArtista(){
        Artista artista= new Artista();
        artista.setNombre(nombre);
        artista.setApellido(apellido);
        artista.setFechaNacimiento(fechaNacimiento);
        artista.setNacionalidad(nacionalidad);
        return artista;
    }
}
