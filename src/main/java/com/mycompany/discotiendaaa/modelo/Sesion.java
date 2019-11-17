/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

/**
 *
 * @author familia manrique
 */
public class Sesion {

    public boolean validarSesion(String usuario, String contrasena) {
        if ("juanita123".equals(usuario) && "1234".equals(contrasena)) {
            return true;
        }
        return false;
    }
}
