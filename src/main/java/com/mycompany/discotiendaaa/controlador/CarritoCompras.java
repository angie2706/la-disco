/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.CancionDB;
import com.mycompany.discotiendaaa.modelo.ComprasDB;
import com.mycompany.discotiendaaa.pojo.Compras;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author angie
 */
@Named(value = "carritoCompras")
@SessionScoped

public class CarritoCompras implements Serializable{

    private List<Compras> listaCarroCompras;
    private List<Compras> listaCanciones;
    private float valortotal;
    private List<Compras> cancionFiltro;
    private List<String> nomArtistas;
    private List<String> nomDiscos;
    ComprasDB comprasDB;
    CancionDB cancionDB;

    public CarritoCompras() {
        comprasDB = new ComprasDB();
        listaCanciones = new ArrayList();
        cancionDB = new CancionDB();
        nomDiscos = new ArrayList();
        nomArtistas = new ArrayList(); 
        cancionFiltro= new ArrayList();
        listaCarroCompras= new ArrayList();
    }

    public void finalizarCompra() {

    }

    public void cancelarCompra() {

    }

    public void agregarAlCarrito() {
        for (Compras c : listaCanciones) {
            if (c.isSeleccion()) {
                listaCarroCompras.add(c);
            }
        }
    }


public List<Compras> getListaCarroCompras() {
        return listaCarroCompras;
    }

    public void setListaCarroCompras(List<Compras> listaCarroCompras) {
        this.listaCarroCompras = listaCarroCompras;
    }

    public List<Compras> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Compras> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
      
    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public List<Compras> getCancionFiltro() {
        return cancionFiltro;
    }

    public void setCancionFiltro(List<Compras> cancionFiltro) {
        this.cancionFiltro = cancionFiltro;
    }

    public List<String> getNomArtistas() {
        return nomArtistas;
    }

    public void setNomArtistas(List<String> nomArtistas) {
        this.nomArtistas = nomArtistas;
    }

    public List<String> getNomDiscos() {
        return nomDiscos;
    }

    public void setNomDiscos(List<String> nomDiscos) {
        this.nomDiscos = nomDiscos;
    }
    
    public void llenarListas() {
        listaCanciones.addAll(comprasDB.consultarCanciones());
        nomDiscos.addAll(cancionDB.consultarNombreDiscos());
        nomArtistas.addAll(comprasDB.consultarNombreArtista());
    }
    
    @PostConstruct
    public void init() {
        llenarListas();
    }
}
