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

    private int id_cancion;
    private String nombre;
    private String caratula;
    private int id_artista;

    public Disco(int id_cancion, String nombre, String caratula, int id_artista) {
        this.id_cancion = id_cancion;
        this.nombre = nombre;
        this.caratula = caratula;
        this.id_artista = id_artista;
    }
    
    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
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

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

}
