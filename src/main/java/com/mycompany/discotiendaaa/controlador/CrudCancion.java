/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.CancionDB;
import com.mycompany.discotiendaaa.pojo.Cancion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author familia manrique
 */
@Named(value = "crudCancion")
@SessionScoped
public class CrudCancion implements Serializable{
    
    private String nombre;
    private String duracion, disco;
    private int id_disco;
    private float precio;
    private List<Cancion> listadoCanciones;
    private List<String> nombreDiscos;
    CancionDB cancionDB;

    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
        cancionDB = new CancionDB();
    }

    @PostConstruct
    public void init() {
        llenarListadoDiscos();
    }

    private void llenarListadoDiscos() {
        nombreDiscos = new ArrayList();
        nombreDiscos.add("gggg");
        nombreDiscos.add("fg");
        nombreDiscos.add("gghhhgg");
    }

    public void llenarListaCanciones() {
        try {
            cancionDB.agregarCancion(nombre, duracion, id_disco, precio);
            
        } catch (Exception e) {
            Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE,
                    "error metodo llenarListaCanciones() :" + CrudCancion.class.getName() + " " + e, e);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }


    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Cancion> getListadoCanciones() {
        return listadoCanciones;
    }

    public void setListadoCanciones(List<Cancion> listadoCanciones) {
        this.listadoCanciones = listadoCanciones;
    }

    public CancionDB getCancionDB() {
        return cancionDB;
    }

    public void setCancionDB(CancionDB cancionDB) {
        this.cancionDB = cancionDB;
    }

    public List<String> getNombreDiscos() {
        return nombreDiscos;
    }

    public void setNombreDiscos(List<String> nombreDiscos) {
        this.nombreDiscos = nombreDiscos;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }
    
}
