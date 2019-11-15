/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author familia manrique
 */
@Named(value = "principalControl")
@SessionScoped
public class PrincipalControl implements Serializable {
    private String seleccion="artista.xhtml";
    
    public PrincipalControl() {
    }
    
    public void irCancion(){
        seleccion="cancion.xhtml";
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    
}
