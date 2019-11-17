/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.CancionDB;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author familia manrique
 */
@Named(value = "principal")
@SessionScoped
public class Principal implements Serializable {

    /**
     * Creates a new instance of Principal
     */
    private String pagina = "/usuario/comprarCancion.xhtml";

    public Principal() {
        
    }

    public void irCancion() {
        pagina = "/usuario/comprarCancion.xhtml";
    }

    public void irLogin() {
        pagina = "./../login.xhtml";
    }

    public void irDisco() {
        pagina = "/usuario/comprarDisco.xhtml";
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
  
}
