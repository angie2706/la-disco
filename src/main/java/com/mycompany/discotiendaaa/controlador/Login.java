/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.logica.Sesion;
import com.mycompany.discotiendaaa.modelo.CancionDB;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author familia manrique
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String nombre;
    private String contrasena;

    /**
     * Creates a new instance of login
     */
    public Login() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String iniciarSesion() {
        String redireccion = null;
        Sesion sesion = new Sesion();
        boolean validacion = sesion.validarSesion(nombre, contrasena);
        FacesContext context = FacesContext.getCurrentInstance();
        if (validacion == true) {
            context.getExternalContext().getSessionMap().put("usuario", nombre);
            redireccion = "/admin/principalAdmin.xhtml";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Acceso denegado", "Usuario y/o contraseña incorrecta"));
        }
        return redireccion;
    }
    
    public void validarPermiso() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        String usuarioLogin = (String) context.getExternalContext().getSessionMap().get("usuario");
        if (!req.getRequestURI().contains("./faces/login.xhtml")) {
            if (req.getRequestURI().contains("/admin/")) {
                if (usuarioLogin == null) {
                    try {
                        context.getExternalContext().redirect("./../login.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
