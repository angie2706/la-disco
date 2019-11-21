/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.pojo;

/**
 *
 * @author angie
 */
public class Compras {
    private String nombre_cancion;
    private String duracion;
    private String nombre_artista;
    private String nombre_disco;
    private String caratula;
    private float precio;
    private boolean seleccion;

   public Compras(String nombre_cancion, String duracion, String nombre_artista, String nombre_disco,String caratula, float precio) {
        this.nombre_cancion = nombre_cancion;
        this.duracion = duracion;
        this.nombre_artista = nombre_artista;
        this.nombre_disco = nombre_disco;
        this.caratula=caratula;
        this.precio=precio;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getNombre_disco() {
        return nombre_disco;
    }

    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
}
