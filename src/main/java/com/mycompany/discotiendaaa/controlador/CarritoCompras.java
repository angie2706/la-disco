/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.pojo.Cancion;
import com.mycompany.discotiendaaa.pojo.Compras;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author angie
 */
@Named(value = "carritoCompras")
@Dependent
public class CarritoCompras {
    private List<Cancion> listaCarroCompras;
    private float valortotal;
    private List<Compras> cancionFiltro;
    /**
     * Creates a new instance of CarritoCompras
     */
    public CarritoCompras() {
    }
    
    public void finalizarCompra(){
        
    }
    
    public void cancelarCompra(){
        
    }

    public List<Cancion> getListaCarroCompras() {
        return listaCarroCompras;
    }

    public void setListaCarroCompras(List<Cancion> listaCarroCompras) {
        this.listaCarroCompras = listaCarroCompras;
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
    
    
}
