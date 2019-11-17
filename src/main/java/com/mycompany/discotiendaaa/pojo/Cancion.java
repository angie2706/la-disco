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
public class Cancion {

    private String nombre;
    private String duracion;
    private int id_disco;
    private String nombre_disco;
    private float precio;


     public Cancion(String nombre, String duracion, String nombre_disco, float precio) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.nombre_disco = nombre_disco;
        this.precio = precio;
    }
      
    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public String getNombre_disco() {
        return nombre_disco;
    }

    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
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
   
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
