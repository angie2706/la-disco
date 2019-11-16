/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import java.io.Serializable;
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
    private String duracion;
    private String disco;
    private double precio;
    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
        
    }
    
    public void crearCancion(){
        
    }
}
