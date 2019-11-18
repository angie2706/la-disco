/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.pojo;

/**
 *
 * @author familia manrique
 */
public class Disco {

    private int id_disco;
    private String nombre;
    private String caratula;
    private String nombre_artista;
    private boolean seleccion;

    public Disco(int id_disco, String nombre, String caratula, String nombre_artista) {
        this.id_disco = id_disco;
        this.nombre = nombre;
        this.caratula = caratula;
        this.nombre_artista = nombre_artista;
    }
    
    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String id_artista) {
        this.nombre_artista = id_artista;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

}
